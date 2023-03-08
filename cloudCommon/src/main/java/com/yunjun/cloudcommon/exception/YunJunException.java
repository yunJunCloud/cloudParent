package com.yunjun.cloudcommon.exception;

import java.io.Serial;
import java.io.Serializable;

/**
 * @PACKAGE_NAME: com.yunjun.cloudcommon.exception
 * @NAME: YunjunException 自定义异常类
 * @USER: jack
 * @DATE: 3/6/2023
 * @PROJECT_NAME: cloudParent
 **/
public class YunJunException extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = -5805041984226148125L;

    /**
     * 错误码
     */
    protected int errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public YunJunException(int errorCode, String errorMsg) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public YunJunException(BaseErrorInfo baseErrorInfo){
        super(baseErrorInfo.getResultMsg());
        this.errorCode = baseErrorInfo.getResultCode();
        this.errorMsg = baseErrorInfo.getResultMsg();
    }

    public YunJunException(BaseErrorInfo baseErrorInfo, Throwable cause) {
        super(baseErrorInfo.getResultMsg(), cause);
        this.errorCode = baseErrorInfo.getResultCode();
        this.errorMsg = baseErrorInfo.getResultMsg();
    }

    public YunJunException(Throwable cause, int errorCode, String errorMsg) {
        super(errorMsg,cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
