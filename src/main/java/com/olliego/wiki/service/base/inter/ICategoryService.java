package com.olliego.wiki.service.base.inter;

import com.olliego.wiki.model.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author olliego
 * @since 2022-03-13
 */
public interface ICategoryService extends IService<Category> {

    void deleteById(Long id);
}
