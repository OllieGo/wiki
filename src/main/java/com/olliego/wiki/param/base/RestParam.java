package com.olliego.wiki.param.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 接口参数bean父类   在拦截器里面通过手写代码校验以下参数，不需要再此处加validation注解
 *
 */
@ApiModel
@Setter
@Getter
@ToString
public abstract class RestParam implements Serializable {


    @ApiModelProperty(required = true)
    private String appKey;

    @ApiModelProperty(required = true)
    private String appId;


    @ApiModelProperty(required = false)
    private String sign;


    @ApiModelProperty(required = true)
    private Long timestamp;                //时间戳

    @ApiModelProperty(required = false)
    private Integer platform;        //客户端系统类型 1=ios 2=android 3=web


    @ApiModelProperty(hidden = true)
    private RestContext restContext;    //Rest接口用户上下文信息

    @ApiModelProperty("调用者ip地址")
    private String ip;

}
