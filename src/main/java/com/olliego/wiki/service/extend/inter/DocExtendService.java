package com.olliego.wiki.service.extend.inter;

import com.olliego.wiki.param.doc.DocSaveParam;
import com.olliego.wiki.param.doc.DocSearchParam;
import com.olliego.wiki.result.DocVO;
import com.olliego.wiki.result.PageVO;
import com.olliego.wiki.result.RestResult;

import java.util.List;

public interface DocExtendService {

    RestResult<PageVO<DocVO>> queryPage(DocSearchParam param);

    RestResult<List<DocVO>> listNoPage(DocSearchParam param);

    RestResult save(DocSaveParam param);

    RestResult delete(Long id);
}
