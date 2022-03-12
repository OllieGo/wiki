package com.olliego.wiki.param.ebook;
import com.olliego.wiki.param.base.RestPageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: olliego
 * @Title: EbookSearchParam
 * @ProjectName: wiki
 * @Description:
 * @Date: 2022/2/11 10:50
 */
@Data
@ApiModel(value = "电子书保存模型")
public class EbookSaveParam extends RestPageParam {

    private static final long serialVersionUID = -8459140131862628628L;

    private Long id;

    @NotNull(message = "名称不能为空")
    @ApiModelProperty(value = "电子书名称")
    private String name;

    private Long categoryOneId;

    private Long categoryTwoId;

    private String description;

    private String cover;

    private Integer docCount;

    private Integer viewCount;

    private Integer voteCount;

}
