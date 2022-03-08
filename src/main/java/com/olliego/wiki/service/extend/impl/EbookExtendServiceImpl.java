package com.olliego.wiki.service.extend.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.olliego.wiki.model.Ebook;
import com.olliego.wiki.param.ebook.EbookSaveParam;
import com.olliego.wiki.param.ebook.EbookSearchParam;
import com.olliego.wiki.resp.RestResult;
import com.olliego.wiki.result.EbookVO;
import com.olliego.wiki.result.PageVO;
import com.olliego.wiki.service.base.inter.IEbookService;
import com.olliego.wiki.service.extend.inter.EbookExtendService;
import com.olliego.wiki.utils.CopyUtil;
import com.olliego.wiki.utils.ObjectCopyUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 电子书 服务实现类
 * </p>
 *
 * @author olliego
 * @since 2022-02-10
 */
@Service
public class EbookExtendServiceImpl implements EbookExtendService {

    @Resource
    private IEbookService iEbookService;

    @Override
    public RestResult<PageVO<EbookVO>> queryPage(EbookSearchParam param) {
        LambdaQueryWrapper<Ebook> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(param.getName()), Ebook::getName, param.getName());
        queryWrapper.orderByDesc(Ebook::getId);
        IPage<Ebook> page = iEbookService.page(new Page<>(param.getPageNum(), param.getPageSize()), queryWrapper);

        List<Ebook> ebookList = page.getRecords();
        if (CollectionUtils.isEmpty(ebookList)) {
            return RestResult.wrapSuccessResponse(new PageVO<>(new ArrayList<>(), 0L, 0,
                    param.getPageNum(), param.getPageSize()));
        }

        List<EbookVO> ebookVOS = CopyUtil.copyList(ebookList, EbookVO.class);
        PageVO<EbookVO> pageVO = new PageVO<>(ebookVOS, page.getTotal(), (int) page.getPages()
                , (int) page.getCurrent(), (int) page.getSize());
        return RestResult.wrapSuccessResponse(pageVO);
    }

    @Override
    public RestResult save(EbookSaveParam param) {
        Ebook ebook = CopyUtil.copy(param, Ebook.class);
        if (ObjectUtils.isEmpty(param.getId())) {
            //新增
            iEbookService.save(ebook);
        } else {
            //更新
            iEbookService.updateById(ebook);
        }

        return RestResult.wrapSuccessResponse();
    }
}
