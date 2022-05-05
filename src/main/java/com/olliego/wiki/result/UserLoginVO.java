package com.olliego.wiki.result;

import com.olliego.wiki.param.base.RestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Author: olliego
 * @Title: UserLoginVO
 * @ProjectName: wiki
 * @Description:
 * @Date: 2022/4/24 10:50
 */
@Data
@ApiModel(value = "用户登录返回模型")
public class UserLoginVO extends RestParam {

    private static final long serialVersionUID = -343896831570311289L;

    private Long id;

    private String loginName;

    private String name;

    private String token;

}
