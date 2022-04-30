package com.olliego.wiki.param.user;

import com.olliego.wiki.param.base.RestPageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: olliego
 * @Title: UserSearchParam
 * @ProjectName: wiki
 * @Description:
 * @Date: 2022/4/24 10:50
 */
@Data
@NoArgsConstructor
@ApiModel(value = "用户查询模型")
public class UserSearchParam extends RestPageParam {

    private static final long serialVersionUID = -6430640135215042529L;

    @ApiModelProperty(value = "用户名")
    private String loginName;

}
