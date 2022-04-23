package com.olliego.wiki.service.extend.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.olliego.wiki.config.WikiConstants;
import com.olliego.wiki.model.Content;
import com.olliego.wiki.model.Doc;
import com.olliego.wiki.param.doc.DocSaveParam;
import com.olliego.wiki.param.doc.DocSearchParam;
import com.olliego.wiki.result.DocVO;
import com.olliego.wiki.result.PageVO;
import com.olliego.wiki.result.RestResult;
import com.olliego.wiki.service.base.inter.IContentService;
import com.olliego.wiki.service.base.inter.IDocService;
import com.olliego.wiki.service.extend.inter.DocExtendService;
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
import java.util.Objects;

@Service
public class DocExtendServiceImpl implements DocExtendService {

    @Resource
    private IDocService iDocService;
    @Resource
    private SnowFlake snowFlake;
    @Resource
    private IContentService iContentService;

    @Override
    public RestResult<PageVO<DocVO>> queryPage(DocSearchParam param) {
        LambdaQueryWrapper<Doc> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Doc::getEbookId, param.getEbookId());
        queryWrapper.eq(Doc::getDeleted, WikiConstants.ZERO);
        queryWrapper.like(StringUtils.isNotBlank(param.getName()), Doc::getName, param.getName());
        queryWrapper.orderByAsc(Doc::getSort);
        IPage<Doc> page = iDocService.page(new Page<>(param.getPageNum(), param.getPageSize()), queryWrapper);

        List<Doc> DocList = page.getRecords();
        if (CollectionUtils.isEmpty(DocList)) {
            return RestResult.wrapSuccessResponse(new PageVO<>(new ArrayList<>(), 0L, 0,
                    param.getPageNum(), param.getPageSize()));
        }

        List<DocVO> DocVOS = CopyUtil.copyList(DocList, DocVO.class);
        PageVO<DocVO> pageVO = new PageVO<>(DocVOS, page.getTotal(), (int) page.getPages()
                , (int) page.getCurrent(), (int) page.getSize());
        return RestResult.wrapSuccessResponse(pageVO);
    }

    @Override
    public RestResult<List<DocVO>> listNoPage(DocSearchParam param) {
        LambdaQueryWrapper<Doc> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Doc::getEbookId, param.getEbookId());
        queryWrapper.eq(Doc::getDeleted, WikiConstants.ZERO);
        queryWrapper.like(StringUtils.isNotBlank(param.getName()), Doc::getName, param.getName());
        queryWrapper.orderByAsc(Doc::getSort);
        List<Doc> DocList = iDocService.list(queryWrapper);
        List<DocVO> DocVOS = CopyUtil.copyList(DocList, DocVO.class);

        return RestResult.wrapSuccessResponse(DocVOS);
    }

    @Override
    public RestResult save(DocSaveParam param) {
        Doc doc = CopyUtil.copy(param, Doc.class);
        Content content = new Content();
        content.setContent(param.getContent());
        Date now = Date.from(Instant.now());

        if (ObjectUtils.isEmpty(param.getId())) {
            //新增
            doc.setId(snowFlake.nextId());
            doc.setCreateTime(now);
            iDocService.save(doc);

            content.setId(doc.getId());
            content.setCreateTime(now);
            iContentService.save(content);
        } else {
            //更新
            iDocService.updateById(doc);

            Content oldContent = iContentService.queryContentById(param.getId());
            if (oldContent != null) {
                content.setId(oldContent.getId());
                content.setModifyTime(now);
                iContentService.updateById(content);
            } else {
                content.setId(doc.getId());
                content.setCreateTime(now);
                iContentService.save(content);
            }

        }

        return RestResult.wrapSuccessResponse();
    }

    @Override
    public RestResult delete(Long id) {
        iDocService.deleteById(id);
        return RestResult.wrapSuccessResponse();
    }

    @Override
    public RestResult delete(List<Long> ids) {
        iDocService.deleteByIds(ids);
        return RestResult.wrapSuccessResponse();
    }

    @Override
    public RestResult findContent(Long id) {
        Content content = iContentService.queryContentById(id);
        if (Objects.isNull(content)) {
            RestResult.wrapSuccessResponse("");
        }

        return RestResult.wrapSuccessResponse(content.getContent());
    }
}
