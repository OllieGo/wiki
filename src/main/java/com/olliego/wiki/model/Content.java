package com.olliego.wiki.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 文档内容表
 * </p>
 *
 * @author olliego
 * @since 2022-03-27
 */
@Data
public class Content extends BaseEntity<Content> {

    private static final long serialVersionUID = -1442064563377183714L;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

}
