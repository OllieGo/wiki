package com.olliego.wiki.constants;

import java.util.HashMap;
import java.util.Map;

public class AbstractRestConstants {

    public static final Integer RESPONSE_CODE_SUCCESS = 1;
    public static final Integer RESPONSE_CODE_FAILED = 0;
    public static final Integer ERROR_CODE_SERVICE_ERROR = 10000;
    public static final Integer ERROR_CODE_SYSTEM_ERROR = 10001;
    public static final Integer ERROR_CODE_SGIN_ERROR = 10002;
    public static final Integer ERROR_CODE_PARAM_ERROR = 10003;
    public static final Integer ERROR_CODE_TOKEN_LOGOUT = 10004;
    public static final Integer ERROR_CODE_USER_NOT_FIND = 10005;
    public static final Integer ERROR_CODE_TOKEN_EXPIRE = 10006;
    public static final Integer ERROR_CODE_TOKEN_FAIL = 10007;
    public static final Integer ERROR_CODE_NOT_LOGIN = 10008;
    public static final Integer ERROR_CODE_AUTHORIZATION_INEXISTENCE = 10009;
    public static final Integer ERROR_CODE_NULL_OBJ = 11000;
    public static Map<Integer, String> commonErrorCodeMap = new HashMap();

    public AbstractRestConstants() {
    }

    public static void initCommonErrorCodeMap(Map<Integer, String> commonErrorCodeMap) {
        commonErrorCodeMap.put(ERROR_CODE_SERVICE_ERROR, "服务异常错误");
        commonErrorCodeMap.put(ERROR_CODE_SYSTEM_ERROR, "系统异常错误");
        commonErrorCodeMap.put(ERROR_CODE_SGIN_ERROR, "签名验证错误");
        commonErrorCodeMap.put(ERROR_CODE_PARAM_ERROR, "参数验证错误");
        commonErrorCodeMap.put(ERROR_CODE_TOKEN_LOGOUT, "登录失效,请重新登录");
        commonErrorCodeMap.put(ERROR_CODE_USER_NOT_FIND, "用户不存在");
        commonErrorCodeMap.put(ERROR_CODE_TOKEN_EXPIRE, "登录过期,请重新登录");
        commonErrorCodeMap.put(ERROR_CODE_TOKEN_FAIL, "身份验证失败");
        commonErrorCodeMap.put(ERROR_CODE_NOT_LOGIN, "请先登录");
        commonErrorCodeMap.put(ERROR_CODE_NULL_OBJ, "空对象");
    }

    public static String getMessage(Integer errorCode) {
        return (String)commonErrorCodeMap.get(errorCode);
    }

    static {
        initCommonErrorCodeMap(commonErrorCodeMap);
    }
}
