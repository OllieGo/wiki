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
@ApiModel(value = "用户保存模型")
public class UserSaveParam extends RestParam {

    private static final long serialVersionUID = -7387559664833557065L;

    private Long id;

    @NotBlank(message = "登录名不能为空")
    @ApiModelProperty(value = "登录名")
    private String loginName;

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String name;

    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$", message = "【密码】至少包含 数字和英文，长度6-32")
    @ApiModelProperty(value = "密码")
    private String password;

}
