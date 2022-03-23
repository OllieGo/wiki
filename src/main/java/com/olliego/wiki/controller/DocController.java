package com.olliego.wiki.controller;


import com.olliego.wiki.param.doc.DocSaveParam;
import com.olliego.wiki.param.doc.DocSearchParam;
import com.olliego.wiki.result.DocVO;
import com.olliego.wiki.result.PageVO;
import com.olliego.wiki.result.RestResult;
import com.olliego.wiki.service.extend.inter.DocExtendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 文档表 前端控制器
 * </p>
 *
 * @author olliego
 * @since 2022-03-23
 */
@RestController
@RequestMapping("/doc")
@Api(tags = "文档管理")
public class DocController {

    @Resource
    private DocExtendService docExtendService;

    @ApiOperation(value = "分类分页列表")
    @PostMapping("/page")
    public RestResult<PageVO<DocVO>> page(@RequestBody DocSearchParam param) {
        return docExtendService.queryPage(param);
    }

    @ApiOperation(value = "分类列表")
    @PostMapping("/all")
    public RestResult<List<DocVO>> all(@RequestBody DocSearchParam param) {
        return docExtendService.listNoPage(param);
    }

    @ApiOperation(value = "新增/更新")
    @PostMapping("/save")
    public RestResult save(@Valid @RequestBody DocSaveParam param) {
        return docExtendService.save(param);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/delete/{id}")
    public RestResult delete(@PathVariable Long id) {
        return docExtendService.delete(id);
    }
    
}
