package com.olliego.wiki.service.base.impl;

import com.olliego.wiki.model.Category;
import com.olliego.wiki.dao.CategoryMapper;
import com.olliego.wiki.service.base.inter.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author olliego
 * @since 2022-03-13
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
