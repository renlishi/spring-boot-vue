package com.rls.springbootvue.model;

import lombok.Data;

@Data
public class BaseBean {
    private Integer currentPage;
    private Integer pageSize;
    private Integer startPosition;
}
