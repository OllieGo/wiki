package com.olliego.wiki.controller;


import com.olliego.wiki.param.category.CategorySaveParam;
import com.olliego.wiki.param.category.CategorySearchParam;
import com.olliego.wiki.result.CategoryVO;
import com.olliego.wiki.result.PageVO;
import com.olliego.wiki.result.RestResult;
import com.olliego.wiki.service.extend.inter.CategoryExtendService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author olliego
 * @since 2022-03-13
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryExtendService categoryExtendService;

    @ApiOperation(value = "分类分页列表")
    @PostMapping("/page")
    public RestResult<PageVO<CategoryVO>> page(@RequestBody CategorySearchParam param) {
        return categoryExtendService.queryPage(param);
    }

    @ApiOperation(value = "分类列表")
    @PostMapping("/all")
    public RestResult<List<CategoryVO>> all() {
        return categoryExtendService.listNoPage();
    }

    @ApiOperation(value = "新增/更新")
    @PostMapping("/save")
    public RestResult save(@Valid @RequestBody CategorySaveParam param) {
        return categoryExtendService.save(param);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/delete/{id}")
    public RestResult delete(@PathVariable Long id) {
        return categoryExtendService.delete(id);
    }
}
