package com.rls.springbootvue.service;

import com.rls.springbootvue.model.Book;

import java.util.List;

public interface BookService {
    List<Book> selectByCondition(Book condition);
    Integer getTotal(Book condition);
}
