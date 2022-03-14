package com.olliego.wiki.param.category;

import com.olliego.wiki.param.base.RestPageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: olliego
 * @Title: CategorySearchParam
 * @ProjectName: wiki
 * @Description:
 * @Date: 2022/3/14 23:50
 */
@Data
@NoArgsConstructor
@ApiModel(value = "分类查询模型")
public class CategorySearchParam extends RestPageParam {

    private static final long serialVersionUID = 931872537603071029L;

    @ApiModelProperty(value = "分类名称")
    private String name;

}
