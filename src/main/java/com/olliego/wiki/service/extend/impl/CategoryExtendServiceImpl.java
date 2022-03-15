package com.olliego.wiki.service.extend.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.olliego.wiki.config.WikiConstants;
import com.olliego.wiki.model.Category;
import com.olliego.wiki.param.category.CategorySaveParam;
import com.olliego.wiki.param.category.CategorySearchParam;
import com.olliego.wiki.result.CategoryVO;
import com.olliego.wiki.result.PageVO;
import com.olliego.wiki.result.RestResult;
import com.olliego.wiki.service.base.inter.ICategoryService;
import com.olliego.wiki.service.extend.inter.CategoryExtendService;
import com.olliego.wiki.utils.CopyUtil;
import com.olliego.wiki.utils.SnowFlake;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CategoryExtendServiceImpl implements CategoryExtendService {

    @Resource
    private ICategoryService iCategoryService;
    @Resource
    private SnowFlake snowFlake;

    @Override
    public RestResult<PageVO<CategoryVO>> queryPage(CategorySearchParam param) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getDeleted, WikiConstants.ZERO);
        queryWrapper.like(StringUtils.isNotBlank(param.getName()), Category::getName, param.getName());
        queryWrapper.orderByAsc(Category::getSort);
        IPage<Category> page = iCategoryService.page(new Page<>(param.getPageNum(), param.getPageSize()), queryWrapper);

        List<Category> categoryList = page.getRecords();
        if (CollectionUtils.isEmpty(categoryList)) {
            return RestResult.wrapSuccessResponse(new PageVO<>(new ArrayList<>(), 0L, 0,
                    param.getPageNum(), param.getPageSize()));
        }

        List<CategoryVO> categoryVOS = CopyUtil.copyList(categoryList, CategoryVO.class);
        PageVO<CategoryVO> pageVO = new PageVO<>(categoryVOS, page.getTotal(), (int) page.getPages()
                , (int) page.getCurrent(), (int) page.getSize());
        return RestResult.wrapSuccessResponse(pageVO);
    }

    @Override
    public RestResult<List<CategoryVO>> listNoPage() {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getDeleted, WikiConstants.ZERO);
        //queryWrapper.like(StringUtils.isNotBlank(param.getName()), Category::getName, param.getName());
        queryWrapper.orderByAsc(Category::getSort);
        List<Category> categoryList = iCategoryService.list(queryWrapper);
        List<CategoryVO> categoryVOS = CopyUtil.copyList(categoryList, CategoryVO.class);

        return RestResult.wrapSuccessResponse(categoryVOS);
    }

    @Override
    public RestResult save(CategorySaveParam param) {
        Category category = CopyUtil.copy(param, Category.class);
        if (ObjectUtils.isEmpty(param.getId())) {
            //新增
            category.setId(snowFlake.nextId());
            Date now = Date.from(Instant.now());
            category.setCreateTime(now);
            iCategoryService.save(category);
        } else {
            //更新
            iCategoryService.updateById(category);
        }

        return RestResult.wrapSuccessResponse();
    }

    @Override
    public RestResult delete(Long id) {
        iCategoryService.deleteById(id);
        return RestResult.wrapSuccessResponse();
    }
}
