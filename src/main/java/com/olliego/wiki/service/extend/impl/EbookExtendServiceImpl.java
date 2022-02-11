package com.olliego.wiki.service.extend.impl;


import com.olliego.wiki.model.Ebook;
import com.olliego.wiki.param.EbookSearchParam;
import com.olliego.wiki.resp.RestResult;
import com.olliego.wiki.result.EbookVO;
import com.olliego.wiki.service.base.inter.IEbookService;
import com.olliego.wiki.service.extend.inter.EbookExtendService;
import com.olliego.wiki.utils.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public RestResult<List<EbookVO>> queryList(EbookSearchParam param) {
        List<Ebook> ebookList = iEbookService.listNoPage(param);
        List<EbookVO> ebookVOList = CopyUtil.copyList(ebookList, EbookVO.class);
        return RestResult.wrapSuccessResponse(ebookVOList);
    }
}
