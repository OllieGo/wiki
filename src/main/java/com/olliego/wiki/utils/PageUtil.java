package com.olliego.wiki.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.olliego.wiki.param.base.RestPageParam;
import com.olliego.wiki.result.PageVO;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;

/**
 * @Author: olliego
 * @Title: PageUtil
 * @ProjectName: wiki
 * @Description:
 * @Date: 2022/3/23 14:05
 */
@Slf4j
public class PageUtil {

    public static  <T> Page<T> convertToPage(RestPageParam pageParam) {
        try {
            Page<T> page = new Page();
            page.setCurrent(pageParam.getPageNum());
            page.setSize(pageParam.getPageSize());
            page.setSearchCount(true);
            return page;
        } catch (Exception var2) {
            log.error("BaseQuery covert to Page<T> failed.", var2);
            throw new RuntimeException(var2);
        }
    }


    public static <SourceBean, TargetBean> PageVO<TargetBean> beanPage2BeanPage(IPage<SourceBean> request, Class<TargetBean> cls) {
        PageVO<TargetBean> result = new PageVO<>();
        result.setTotalSize((int) request.getTotal());
        result.setTotalPage((int) request.getPages());
        result.setPageNum((int) request.getCurrent());
        result.setPageSize((int) request.getSize());
        result.setList(ObjectCopyUtil.beanList2BeanList(request.getRecords(), cls));
        return result;
    }

    public static <SourceBean, TargetBean> PageVO<TargetBean> covertInitPageVO(RestPageParam pageParam) {
        PageVO<TargetBean> result = new PageVO<>();
        result.setTotalSize((int) 0);
        result.setTotalPage((int) 0);
        result.setPageNum((int) pageParam.getPageNum());
        result.setPageSize((int) pageParam.getPageSize());
        result.setList(new ArrayList<>());
        return result;
    }

    /**
     * 空数据pageVO
     * @param param
     * @return
     */
    public static PageVO getBlankPageVO(RestPageParam param) {
        return new PageVO(new ArrayList<>(), 0L, 0, param.getPageNum(), param.getPageSize());
    }
}