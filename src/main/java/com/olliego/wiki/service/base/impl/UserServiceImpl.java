package com.olliego.wiki.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.olliego.wiki.config.WikiConstants;
import com.olliego.wiki.model.User;
import com.olliego.wiki.dao.UserMapper;
import com.olliego.wiki.service.base.inter.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author olliego
 * @since 2022-04-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User queryById(Long id) {
        LambdaUpdateWrapper<User> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(User::getDeleted, WikiConstants.ZERO);
        wrapper.eq(User::getId, id);
        return getOne(wrapper);
    }

    @Override
    public void deleteById(Long id) {
        LambdaUpdateWrapper<User> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(User::getId, id);
        remove(wrapper);
    }
}
