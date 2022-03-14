package com.olliego.wiki.service.extend.inter;

import com.olliego.wiki.param.category.CategorySaveParam;
import com.olliego.wiki.param.category.CategorySearchParam;
import com.olliego.wiki.result.CategoryVO;
import com.olliego.wiki.result.PageVO;
import com.olliego.wiki.result.RestResult;

public interface CategoryExtendService {

    RestResult<PageVO<CategoryVO>> queryPage(CategorySearchParam param);

    RestResult save(CategorySaveParam param);

    RestResult delete(Long id);
}
