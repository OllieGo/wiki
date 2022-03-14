package com.olliego.wiki.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author olliego
 * @since 2022-03-13
 */
@Data
public class Category extends BaseEntity<Category> {

    private static final long serialVersionUID = 7547758261372659256L;

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

}
