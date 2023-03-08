package com.yunjun.cloudcommon.model;

import com.yunjun.cloudcommon.exception.BaseErrorInfo;
import com.yunjun.cloudcommon.exception.CommonEum;

/**
 * @PACKAGE_NAME: com.yunjun.productcommon.model
 * @NAME: RestResultUtils
 * @USER: jack
 * @DATE: 2/27/2023
 * @PROJECT_NAME: cloudParent
 **/
public class RestResultUtils {
    public static <T> RestResult<T> success(){
        return RestResult.<T>builder().withCode(CommonEum.SUCCESS.getResultCode()).build();
    }
    public static <T> RestResult<T> success(T data) {
        return RestResult.<T>builder().withCode(CommonEum.SUCCESS.getResultCode()).withData(data).build();
    }

    public static <T> RestResult<T> success(String msg, T data) {
        return RestResult.<T>builder().withCode(CommonEum.SUCCESS.getResultCode()).withMsg(CommonEum.SUCCESS.getResultMsg()).withData(data).build();
    }


    public static <T> RestResult<T> success(int code, T data) {
        return RestResult.<T>builder().withCode(code).withData(data).build();
    }

    public static <T> RestResult<T> failed() {
        return RestResult.<T>builder().withCode(CommonEum.INTERNAL_SERVER_ERROR.getResultCode()).build();
    }

    public static <T> RestResult<T> failed(String errMsg) {
        return RestResult.<T>builder().withCode(CommonEum.INTERNAL_SERVER_ERROR.getResultCode()).withMsg(CommonEum.INTERNAL_SERVER_ERROR.getResultMsg()).build();
    }

    public static <T> RestResult<T> failed(int code, T data) {
        return RestResult.<T>builder().withCode(code).withData(data).build();
    }

    public static <T> RestResult<T> failed(int code, T data, String errMsg) {
        return RestResult.<T>builder().withCode(code).withData(data).withMsg(errMsg).build();
    }

    public static <T> RestResult<T> failedWithMsg(int code, String errMsg) {
        return RestResult.<T>builder().withCode(code).withMsg(errMsg).build();
    }

    public static <T> RestResult<T> failedWithMsg(BaseErrorInfo baseErrorInfo) {
        return RestResult.<T>builder().withCode(baseErrorInfo.getResultCode()).withMsg(baseErrorInfo.getResultMsg()).build();
    }
}
