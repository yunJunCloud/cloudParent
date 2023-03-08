package com.yunjun.cloudcommon.exception;

/**
 * 基础错误接口
 */
public interface BaseErrorInfo {
    int getResultCode();
    String getResultMsg();
}
