package com.olliego.wiki.service.extend.inter;

import com.olliego.wiki.param.EbookSearchParam;
import com.olliego.wiki.resp.RestResult;
import com.olliego.wiki.result.EbookVO;
import java.util.List;

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
     * 电子书列表接口
     * @param param
     * @return
     */
    RestResult<List<EbookVO>> queryList(EbookSearchParam param);

}
