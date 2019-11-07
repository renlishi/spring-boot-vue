package com.rls.springbootvue;

import com.alibaba.fastjson.JSON;
import com.rls.springbootvue.dao.BookDao;
import com.rls.springbootvue.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootVueApplicationTests {
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        Book page = new Book();
        page.setStartPosition(1);
        page.setPageSize(2);
        List<Book> list = bookDao.selectByCondition(page);
        System.out.println(JSON.toJSONString(list));
    }

}
