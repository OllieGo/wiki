package com.olliego.wiki.service.extend.inter;

import com.olliego.wiki.param.ebook.EbookSaveParam;
import com.olliego.wiki.param.ebook.EbookSearchParam;
import com.olliego.wiki.resp.RestResult;
import com.olliego.wiki.result.EbookVO;
import com.olliego.wiki.result.PageVO;



/**
 * <p>
 * 电子书 服务拓展类
 * </p>
 *
 * @author olliego
 * @since 2022-02-10
 */
public interface EbookExtendService {

    /**
     * 电子书分页
     * @param param
     * @return
     */
    RestResult<PageVO<EbookVO>> queryPage(EbookSearchParam param);

    RestResult save(EbookSaveParam param);

}
