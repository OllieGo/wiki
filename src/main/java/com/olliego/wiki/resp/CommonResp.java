package com.olliego.wiki.resp;

import com.olliego.wiki.constants.AbstractRestConstants;

public class CommonResp<T> {

    /**
     * 业务上的成功或失败
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回泛型数据，自定义类型
     */
    private T data;

    public CommonResp() {
    }

    public CommonResp(Integer code) {
        this.code = code;
    }

    public CommonResp(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResp(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public CommonResp(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return this.code == null ? 0 : this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> CommonResp<T> wrapSuccessResponse() {
        return new CommonResp(AbstractRestConstants.RESPONSE_CODE_SUCCESS);
    }

    public static <T> CommonResp<T> wrapSuccessResponse(T data) {
        return new CommonResp(AbstractRestConstants.RESPONSE_CODE_SUCCESS, data);
    }

    public static <T> CommonResp<T> wrapErrorResponse(String msg) {
        return new CommonResp(AbstractRestConstants.RESPONSE_CODE_FAILED, msg);
    }

    public static <T> CommonResp<T> wrapErrorResponse(Integer code, String msg) {
        return new CommonResp(code, msg);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResponseDto{");
        sb.append("code=").append(code);
        sb.append(", message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
