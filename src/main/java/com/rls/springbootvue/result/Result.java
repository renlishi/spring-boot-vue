package com.rls.springbootvue.result;

import lombok.Data;

@Data
public class Result {
    private Integer code;

    private String msg;

    private Object data;

    // 几个常用方法
    public Result success(ResultCode ResultCode) {
        return successData(ResultCode, null);
    }

    public Result successData(ResultCode ResultCode, Object data) {
        return new Result(ResultCode.getCode(), ResultCode.getMessage(), data);
    }


    // 几个构造方法
    public Result() {
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }
}
