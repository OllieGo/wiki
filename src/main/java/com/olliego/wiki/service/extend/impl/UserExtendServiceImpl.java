package com.olliego.wiki.service.extend.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.olliego.wiki.config.WikiConstants;
import com.olliego.wiki.exception.BusinessExceptionCode;
import com.olliego.wiki.model.User;
import com.olliego.wiki.param.user.UserLoginParam;
import com.olliego.wiki.param.user.UserResetPasswordParam;
import com.olliego.wiki.param.user.UserSaveParam;
import com.olliego.wiki.param.user.UserSearchParam;
import com.olliego.wiki.result.PageVO;
import com.olliego.wiki.result.RestResult;
import com.olliego.wiki.result.UserLoginVO;
import com.olliego.wiki.result.UserVO;
import com.olliego.wiki.service.base.inter.IUserService;
import com.olliego.wiki.service.extend.inter.UserExtendService;
import com.olliego.wiki.utils.CopyUtil;
import com.olliego.wiki.utils.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class UserExtendServiceImpl implements UserExtendService {

    @Resource
    private IUserService iUserService;
    @Resource
    private SnowFlake snowFlake;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public RestResult<PageVO<UserVO>> queryPage(UserSearchParam param) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getDeleted, WikiConstants.ZERO);
        queryWrapper.like(StringUtils.isNotBlank(param.getLoginName()), User::getLoginName, param.getLoginName());
        IPage<User> page = iUserService.page(new Page<>(param.getPageNum(), param.getPageSize()), queryWrapper);

        List<User> userList = page.getRecords();
        if (CollectionUtils.isEmpty(userList)) {
            return RestResult.wrapSuccessResponse(new PageVO<>(new ArrayList<>(), 0L, 0,
                    param.getPageNum(), param.getPageSize()));
        }

        List<UserVO> userVOS = CopyUtil.copyList(userList, UserVO.class);
        PageVO<UserVO> pageVO = new PageVO<>(userVOS, page.getTotal(), (int) page.getPages()
                , (int) page.getCurrent(), (int) page.getSize());
        return RestResult.wrapSuccessResponse(pageVO);
    }

    @Override
    public RestResult save(UserSaveParam param) {

        param.setPassword(DigestUtils.md5DigestAsHex(param.getPassword().getBytes()));
        if (ObjectUtils.isEmpty(param.getId())) {
            //新增
            User sameLoginNameUser = iUserService.queryByLoginName(param.getLoginName());
            if (Objects.nonNull(sameLoginNameUser)) {
                return RestResult.wrapErrorResponse("用户名已存在！");

            } else {
                User user = CopyUtil.copy(param, User.class);
                user.setId(snowFlake.nextId());
                iUserService.save(user);
            }

        } else {
            //更新
            User user = iUserService.queryById(param.getId());
            user.setName(param.getName());
            user.setLoginName(null);
            user.setPassword(null);
            iUserService.updateById(user);
        }

        return RestResult.wrapSuccessResponse();
    }

    @Override
    public RestResult delete(Long id) {
        iUserService.deleteById(id);
        return RestResult.wrapSuccessResponse();
    }

    @Override
    public RestResult resetPassword(UserResetPasswordParam param) {
        param.setPassword(DigestUtils.md5DigestAsHex(param.getPassword().getBytes()));
        User user = CopyUtil.copy(param, User.class);
        iUserService.updateById(user);
        return RestResult.wrapSuccessResponse();
    }

    @Override
    public RestResult login(UserLoginParam param) {
        param.setPassword(DigestUtils.md5DigestAsHex(param.getPassword().getBytes()));
        User dbUser = iUserService.queryByLoginName(param.getLoginName());
        if (Objects.nonNull(dbUser)) {
            if (dbUser.getPassword().equals(param.getPassword())) {
                UserLoginVO userLoginVO = CopyUtil.copy(dbUser, UserLoginVO.class);

                //生成单点登录token，并放入redis中
                Long token = snowFlake.nextId();
                log.info("token:{}", token);
                redisTemplate.opsForValue().set(token, userLoginVO, 3600 * 24, TimeUnit.SECONDS);
                userLoginVO.setToken(token.toString());

                return RestResult.wrapSuccessResponse(userLoginVO);
            }
        }
        return RestResult.wrapErrorResponse(BusinessExceptionCode.LOGIN_USER_ERROR.getDesc());
    }
}
