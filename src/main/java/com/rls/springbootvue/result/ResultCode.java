package com.rls.springbootvue.result;

public enum ResultCode {
    SUCCESS(200, "ok"),
    FAILED(301, "账号密码错误"),
    AUTH_ERROR(401, "认证失败"),
    SYS_ERROR(500, "系统错误"),
    PARAM_ERROR(400, "参数错误"),
    UNKNOWN_ERROR(499, "未知错误")
    ;

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return this.code;
    }
}
