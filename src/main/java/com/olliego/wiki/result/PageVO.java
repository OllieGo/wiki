package com.olliego.wiki.result;

import java.io.Serializable;
import java.util.List;

public class PageVO<T> implements Serializable {
    private static final long serialVersionUID = -8740466457973743029L;
    private List<T> list;
    private Integer totalSize;
    private Integer totalPage;
    private Integer pageSize;
    private Integer pageNum;

    public PageVO() {
    }

    public PageVO(List<T> list, Long totalSize, Integer totalPage, Integer pageNum, Integer pageSize) {
        this.list = list;
        if (totalSize != null) {
            this.totalSize = totalSize.intValue();
        }

        this.totalPage = totalPage;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalSize() {
        return this.totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

}
