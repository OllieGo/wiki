package com.olliego.wiki.param.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


@ApiModel
public class RestPageParam extends RestParam implements Serializable {

    @ApiModelProperty(value = "每页展示条数")
    private Integer pageSize;
    @ApiModelProperty(value = "第几页")
    private Integer pageNum;

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum == null ? 1 : pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

}
