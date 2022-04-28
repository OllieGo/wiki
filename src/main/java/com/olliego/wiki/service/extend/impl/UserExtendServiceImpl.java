package com.olliego.wiki.service.extend.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.olliego.wiki.config.WikiConstants;
import com.olliego.wiki.model.User;
import com.olliego.wiki.param.user.UserResetPasswordParam;
import com.olliego.wiki.param.user.UserSaveParam;
import com.olliego.wiki.param.user.UserSearchParam;
import com.olliego.wiki.result.PageVO;
import com.olliego.wiki.result.RestResult;
import com.olliego.wiki.result.UserVO;
import com.olliego.wiki.service.base.inter.IUserService;
import com.olliego.wiki.service.extend.inter.UserExtendService;
import com.olliego.wiki.utils.CopyUtil;
import com.olliego.wiki.utils.SnowFlake;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserExtendServiceImpl implements UserExtendService {

    @Resource
    private IUserService iUserService;
    @Resource
    private SnowFlake snowFlake;

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
                return RestResult.wrapErrorResponse("登录名已存在！");

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
        User user = CopyUtil.copy(param, User.class);
        iUserService.updateById(user);
        return RestResult.wrapSuccessResponse();
    }
}
