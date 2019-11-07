package com.rls.springbootvue.dao;

import com.rls.springbootvue.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    Book selectById(Long id);
    List<Book> selectByCondition(Book condition);
    Integer getTotal(Book condition);
}
