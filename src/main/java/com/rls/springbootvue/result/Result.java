package com.rls.springbootvue.result;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Result<E> {
    private Integer code;

    private String msg;

    private List<E> data;

    public void addE(E e){
        data.add(e);
    }

    private Integer total;
    private Integer currentPage;
    private Integer pageSize;

    // 几个常用方法
    public Result success(ResultCode ResultCode) {
        return successData(ResultCode, null);
    }

    public Result successData(ResultCode ResultCode, List<E> data) {
        return new Result(ResultCode.getCode(), ResultCode.getMessage(), data);
    }


    // 几个构造方法
    public Result() {
        data = new ArrayList<>();
    }

    public Result(Integer code, String message, List<E> data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }
}
