package com.olliego.wiki.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * <p>
 * 电子书
 * </p>
 *
 * @author olliego
 * @since 2022-02-10
 */
@Data
public class Ebook extends BaseEntity<Ebook>  {

    private static final long serialVersionUID = -4818900065773684561L;

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
