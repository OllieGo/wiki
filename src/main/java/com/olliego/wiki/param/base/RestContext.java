package com.olliego.wiki.param.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Rest接口用户上下文信息
 *
 */
@ApiModel
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class RestContext implements Serializable {


    private static final long serialVersionUID = 8799279715276032519L;

    //应用信息
    private Integer applicationId;        //应用ID

    private String applicationKey;        //应用KEY

    //用户信息
    //private Integer tokenId;			//TokenID
    private String tokenUuid;

    private Long userId;                //用户ID

    private Integer userType;            //用户类型

    @ApiModelProperty(value = "用户来源  0：微信 1：支付宝")
    private Integer appType;

    private Integer mgtType;

    private String userLoginName;        //登陆账

    private String userName;            //用户名称

    private String role;

    private String deviceId;

    private Long tenantId;            //tenantId,B端使用

    private Integer identity;           //身份，B端使用  是否有超级权限  0 否 1是

}
