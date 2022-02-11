package com.olliego.wiki.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.olliego.wiki.model.Ebook;
import com.olliego.wiki.dao.EbookMapper;
import com.olliego.wiki.param.EbookSearchParam;
import com.olliego.wiki.resp.RestResult;
import com.olliego.wiki.service.base.inter.IEbookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class EbookServiceImpl extends ServiceImpl<EbookMapper, Ebook> implements IEbookService {

    @Override
    public List<Ebook> listNoPage(EbookSearchParam param) {

        LambdaQueryWrapper<Ebook> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(param.getName()), Ebook::getName, param.getName());
        wrapper.orderByDesc(Ebook::getCreateTime);
        return list(wrapper);
    }
}
