package com.olliego.wiki.param.user;

import com.olliego.wiki.param.base.RestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Author: olliego
 * @Title: UserSaveParam
 * @ProjectName: wiki
 * @Description:
 * @Date: 2022/4/24 10:50
 */
@Data
@ApiModel(value = "用户登录模型")
public class UserLoginParam extends RestParam {

    private static final long serialVersionUID = -692408079831239621L;

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String loginName;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

}
