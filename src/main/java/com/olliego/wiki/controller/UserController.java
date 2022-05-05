package com.olliego.wiki.controller;


import com.olliego.wiki.param.user.UserLoginParam;
import com.olliego.wiki.param.user.UserResetPasswordParam;
import com.olliego.wiki.param.user.UserSaveParam;
import com.olliego.wiki.param.user.UserSearchParam;
import com.olliego.wiki.result.PageVO;
import com.olliego.wiki.result.RestResult;
import com.olliego.wiki.result.UserVO;
import com.olliego.wiki.service.extend.inter.UserExtendService;
import com.olliego.wiki.utils.SnowFlake;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author olliego
 * @since 2022-04-24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserExtendService userExtendService;

    @ApiOperation(value = "用户分页列表")
    @PostMapping("/page")
    public RestResult<PageVO<UserVO>> page(@RequestBody UserSearchParam param) {
        return userExtendService.queryPage(param);
    }

    @ApiOperation(value = "新增/更新")
    @PostMapping("/save")
    public RestResult save(@Valid @RequestBody UserSaveParam param) {
        return userExtendService.save(param);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/delete/{id}")
    public RestResult delete(@PathVariable Long id) {
        return userExtendService.delete(id);
    }

    @ApiOperation(value = "重置密码")
    @PostMapping("/resetPassword")
    public RestResult resetPassword(@Valid @RequestBody UserResetPasswordParam param) {
        return userExtendService.resetPassword(param);
    }

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public RestResult login(@Valid @RequestBody UserLoginParam param) {
        return userExtendService.login(param);
    }
}
