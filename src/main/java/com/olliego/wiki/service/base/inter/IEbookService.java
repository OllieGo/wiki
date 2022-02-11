package com.olliego.wiki.service.base.inter;

import com.olliego.wiki.model.Ebook;
import com.baomidou.mybatisplus.extension.service.IService;
import com.olliego.wiki.param.EbookSearchParam;
import com.olliego.wiki.resp.RestResult;

import java.util.List;

/**
 * <p>
 * 电子书 服务类
 * </p>
 *
 * @author olliego
 * @since 2022-02-10
 */
public interface IEbookService extends IService<Ebook> {

    /**
     * 电子书列表接口
     * @param param
     * @return
     */
    List<Ebook> listNoPage(EbookSearchParam param);

}
