package com.olliego.wiki.service.base.inter;

import com.olliego.wiki.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author olliego
 * @since 2022-04-24
 */
public interface IUserService extends IService<User> {

    User queryById(Long id);

    void deleteById(Long id);
}
