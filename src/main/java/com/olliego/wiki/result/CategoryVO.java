package com.olliego.wiki.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author olliego
 * @since 2022-03-13
 */
@Data
public class CategoryVO implements Serializable {

    private static final long serialVersionUID = 4753661324927326386L;

    /**
     * 主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 创建人
     */
    private String createPeople;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String modifyPeople;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 是否删除 0正常 1删除
     */
    private Integer deleted;

    /**
     * 父id
     */
    private Long parent;

    /**
     * 名称
     */
    private String name;

    /**
     * 顺序
     */
    private Integer sort;

}
