package com.olliego.wiki.param.doc;

import com.olliego.wiki.param.base.RestPageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: olliego
 * @Title: DocSearchParam
 * @ProjectName: wiki
 * @Description:
 * @Date: 2022/3/23 14:05
 */
@Data
@NoArgsConstructor
@ApiModel(value = "文档查询模型")
public class DocSearchParam extends RestPageParam {

    private static final long serialVersionUID = -3097489085664033113L;

    @ApiModelProperty(value = "文档名称")
    private String name;

    @ApiModelProperty(value = "文档id")
    private Long ebookId;

}
