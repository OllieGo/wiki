package com.olliego.wiki.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: gavin
 * @Title: ebookVO
 * @ProjectName: wiki
 * @Description:
 * @Date: 2022/2/11 13:44
 */
@Data
@ApiModel(value = "电子书返回模型")
public class EbookVO implements Serializable {

    private static final long serialVersionUID = 5051851466968966592L;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 分类一
     */
    private Long categoryOneId;

    /**
     * 分类二
     */
    private Long categoryTwoId;

    /**
     * 描述
     */
    private String description;

    /**
     * 封面
     */
    private String cover;

    /**
     * 文档数
     */
    private Integer docCount;

    /**
     * 阅读数
     */
    private Integer viewCount;

    /**
     * 点赞数
     */
    private Integer voteCount;

}
