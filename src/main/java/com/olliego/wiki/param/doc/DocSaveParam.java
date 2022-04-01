package com.olliego.wiki.param.doc;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.olliego.wiki.param.base.RestParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @Author: olliego
 * @Title: DocSaveParam
 * @ProjectName: wiki
 * @Description:
 * @Date: 2022/3/23 14:05
 */
@Data
@NoArgsConstructor
@ApiModel(value = "文档保存模型")
public class DocSaveParam extends RestParam {

    private static final long serialVersionUID = -8632122421408581727L;

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
     * 电子书id
     */
    @NotNull(message = "电子书id不能为空")
    private Long ebookId;

    /**
     * 父id
     */
    @NotNull(message = "父id不能为空")
    private Long parent;

    /**
     * 名称
     */
    @NotNull(message = "名称不能为空")
    private String name;

    /**
     * 顺序
     */
    @NotNull(message = "顺序不能为空")
    private Integer sort;

    /**
     * 阅读数
     */
    private Integer viewCount;

    /**
     * 点赞数
     */
    private Integer voteCount;

    /**
     * 内容
     */
    @NotNull(message = "内容不能为空")
    private String content;
}
