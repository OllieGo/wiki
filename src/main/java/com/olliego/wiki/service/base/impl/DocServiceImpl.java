package com.olliego.wiki.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.olliego.wiki.model.Doc;
import com.olliego.wiki.dao.DocMapper;
import com.olliego.wiki.service.base.inter.IDocService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 文档表 服务实现类
 * </p>
 *
 * @author olliego
 * @since 2022-03-23
 */
@Service
public class DocServiceImpl extends ServiceImpl<DocMapper, Doc> implements IDocService {

    @Override
    public void deleteById(Long id) {
        LambdaUpdateWrapper<Doc> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(Doc::getId, id);
        remove(wrapper);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        LambdaUpdateWrapper<Doc> wrapper = Wrappers.lambdaUpdate();
        wrapper.in(Doc::getId, ids);
        remove(wrapper);
    }

}
