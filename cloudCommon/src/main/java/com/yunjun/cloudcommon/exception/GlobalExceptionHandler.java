package com.yunjun.cloudcommon.exception;

import com.yunjun.cloudcommon.model.RestResult;
import com.yunjun.cloudcommon.model.RestResultUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @PACKAGE_NAME: com.yunjun.cloudcommon.exception
 * @NAME: GlobalExceptionHandler  自定义全局异常处理类
 * @USER: jack
 * @DATE: 3/6/2023
 * @PROJECT_NAME: cloudParent
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = YunJunException.class)
    public RestResult yunJunExceptionHandler(HttpServletRequest request,YunJunException yunJunException){
        log.error("业务发生异常：原因是：{}",yunJunException.getErrorMsg());
        return RestResultUtils.failedWithMsg(yunJunException.getErrorCode(), yunJunException.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    public RestResult exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        return RestResultUtils.failedWithMsg(CommonEum.NULL_EXCEPTION);
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    public RestResult exceptionHandler(HttpServletRequest req, Exception e){
        log.error("未知异常！原因是:",e);
        return RestResultUtils.failed(CommonEum.INTERNAL_SERVER_ERROR.getResultMsg());
    }
}
