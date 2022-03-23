package com.olliego.wiki.model;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * <p>
 * 文档表
 * </p>
 *
 * @author olliego
 * @since 2022-03-23
 */
@Data
public class Doc extends BaseEntity<Doc> {

    private static final long serialVersionUID = -8039364868288153457L;

    /**
     * 电子书id
     */
    @TableField("ebook_id")
    private Long ebookId;

    /**
     * 父id
     */
    @TableField("parent")
    private Long parent;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 顺序
     */
    @TableField("sort")
    private Integer sort;

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
