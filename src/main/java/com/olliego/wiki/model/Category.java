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

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建人
     */
    @TableField("create_people")
    private String createPeople;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @TableField("modify_people")
    private String modifyPeople;

    /**
     * 修改时间
     */
    @TableField("modify_time")
    private LocalDateTime modifyTime;

    /**
     * 是否删除 0正常 1删除
     */
    @TableField("deleted")
    private Integer deleted;

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
