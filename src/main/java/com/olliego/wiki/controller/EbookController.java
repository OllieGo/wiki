package com.olliego.wiki.controller;


import com.olliego.wiki.param.ebook.EbookSaveParam;
import com.olliego.wiki.param.ebook.EbookSearchParam;
import com.olliego.wiki.resp.RestResult;
import com.olliego.wiki.result.EbookVO;
import com.olliego.wiki.result.PageVO;
import com.olliego.wiki.service.extend.inter.EbookExtendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 电子书 前端控制器
 * </p>
 *
 * @author olliego
 * @since 2022-02-10
 */
@RestController
@RequestMapping("/ebook")
@Api(tags = "电子书管理")
public class EbookController {

    @Resource
    private EbookExtendService ebookExtendService;

    @ApiOperation(value = "电子书分页列表")
    @PostMapping("/page")
    public RestResult<PageVO<EbookVO>> page(@RequestBody EbookSearchParam param) {
        return ebookExtendService.queryPage(param);
    }

    @ApiOperation(value = "电子书保存")
    @PostMapping("/save")
    public RestResult save(@RequestBody EbookSaveParam param) {
        return ebookExtendService.save(param);
    }
}
