package com.olliego.wiki.result;

import com.baomidou.mybatisplus.annotation.TableField;
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

    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 分类一
     */
    @TableField("category_one_id")
    private Long categoryOneId;

    /**
     * 分类二
     */
    @TableField("category_two_id")
    private Long categoryTwoId;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 封面
     */
    @TableField("cover")
    private String cover;

    /**
     * 文档数
     */
    @TableField("doc_count")
    private Integer docCount;

    /**
     * 阅读数
     */
    @TableField("view_count")
    private Integer viewCount;

    /**
     * 点赞数
     */
    @TableField("vote_count")
    private Integer voteCount;

}
