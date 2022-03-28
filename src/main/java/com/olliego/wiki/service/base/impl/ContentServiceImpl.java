package com.olliego.wiki.service.base.impl;

import com.olliego.wiki.model.Content;
import com.olliego.wiki.dao.ContentMapper;
import com.olliego.wiki.service.base.inter.IContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文档内容表 服务实现类
 * </p>
 *
 * @author olliego
 * @since 2022-03-27
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements IContentService {

}
