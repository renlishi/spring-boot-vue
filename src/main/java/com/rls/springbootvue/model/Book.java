package com.rls.springbootvue.model;

import lombok.Data;

@Data
public class Book extends BaseBean{
    private Integer id;
    private String cover;
    private String title;
    private String author;
    private String date;
    private String press;
    private String abs;
    private String cid;
}
