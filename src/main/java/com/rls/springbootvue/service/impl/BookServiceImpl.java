package com.rls.springbootvue.service.impl;

import com.rls.springbootvue.dao.BookDao;
import com.rls.springbootvue.model.Book;
import com.rls.springbootvue.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public List<Book> selectByCondition(Book condition) {
        if (null != condition.getPageSize() && null != condition.getCurrentPage()) {
            condition.setStartPosition((condition.getCurrentPage() - 1) * condition.getPageSize());
        }
        return bookDao.selectByCondition(condition);
    }

    @Override
    public Integer getTotal(Book condition) {
        return bookDao.getTotal(condition);
    }
}
