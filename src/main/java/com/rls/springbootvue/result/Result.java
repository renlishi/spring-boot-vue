package com.rls.springbootvue.result;

import lombok.Data;

@Data
public class Result {
    private Integer status;

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

    public Result(Integer state, String message, Object data) {
        this.status = state;
        this.msg = message;
        this.data = data;
    }
}
