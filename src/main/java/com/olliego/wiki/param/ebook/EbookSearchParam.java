package com.olliego.wiki.param.ebook;
import com.olliego.wiki.param.base.RestPageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: olliego
 * @Title: EbookSearchParam
 * @ProjectName: wiki
 * @Description:
 * @Date: 2022/2/11 10:50
 */
@Data
@NoArgsConstructor
@ApiModel(value = "电子书查询模型")
public class EbookSearchParam extends RestPageParam {

    private static final long serialVersionUID = 4825925177378698341L;

    @ApiModelProperty(value = "电子书名称")
    private String name;

    @ApiModelProperty(value = "分类二")
    private Long categoryTwoId;

}
