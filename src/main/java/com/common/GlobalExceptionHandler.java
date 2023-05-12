package com.common;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static Logger log = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {NotLoginException.class})
    public Object handle(NotLoginException e, HandlerMethod m) {
        log.error("用户未登录", e);
        return ResultVO.newInstance(ResultCode.FAIL_DENY);
    }

    @ExceptionHandler(value = {NotPermissionException.class})
    public Object handle(NotPermissionException e, HandlerMethod m) {
        log.error("无此权限", e);
        return ResultVO.newInstance(ResultCode.FAIL_NO_AUTH);
    }
}
