package com.common;

public enum ResultCode {
    SUCCESS(true, "0", "成功"),
    FAIL(false, "1", "失败"),
    FAIL_DENY(false, "2", "用户未登录，访问的接口需求用户登录"),
    FAIL_NO_AUTH(false, "3", "越权访问，没有权限访问的该接口"),
    PARAM_IS_BLANK(false, "101", "参数为空"),
    PARAM_IS_INVALID(false, "102", "参数无效"),
    PARAM_TYEP_ERROR(false, "103", "参数类型错误"),
    PARAM_NOT_COMPLETE(false, "104", "参数缺失"),
    SQL_ERROR_UNIQUE(false, "201", "数据已存在"),
    ERROR(false, "500", "系统发生异常，请联系管理员!"),
    BUSINESS_EXCEPTION(false, "800", "业务异常!");

    private boolean isSuccess;
    private String code;
    private String message;

    private ResultCode(boolean isSuccess, String code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean success) {
        this.isSuccess = success;
    }
}

