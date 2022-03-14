package com.olliego.wiki.param.category;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.olliego.wiki.param.base.RestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: olliego
 * @Title: CategorySaveParam
 * @ProjectName: wiki
 * @Description:
 * @Date: 2022/3/14 23:50
 */
@Data
@NoArgsConstructor
@ApiModel(value = "分类查询模型")
public class CategorySaveParam extends RestParam {

    private static final long serialVersionUID = -8747328622212788501L;

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
    @ApiModelProperty(value = "分类名称")
    private String name;

    /**
     * 顺序
     */
    private Integer sort;
}
