package com.olliego.wiki.param;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: olliego
 * @Title: EbookSearchParam
 * @ProjectName: wiki
 * @Description:
 * @Date: 2022/2/11 10:50
 */
@Data
@ApiModel(value = "电子书查询模型")
public class EbookSearchParam {

    @ApiModelProperty(value = "电子书名称")
    private String name;

}
