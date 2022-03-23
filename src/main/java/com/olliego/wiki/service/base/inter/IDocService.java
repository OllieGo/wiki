package com.olliego.wiki.service.base.inter;

import com.olliego.wiki.model.Doc;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文档表 服务类
 * </p>
 *
 * @author olliego
 * @since 2022-03-23
 */
public interface IDocService extends IService<Doc> {

    void deleteById(Long id);

}
