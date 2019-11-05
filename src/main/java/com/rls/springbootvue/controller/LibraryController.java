package com.rls.springbootvue.controller;

import com.alibaba.fastjson.JSON;
import com.rls.springbootvue.model.Book;
import com.rls.springbootvue.result.Result;
import com.rls.springbootvue.result.ResultCode;
import com.rls.springbootvue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/api/books")
    public Result login(@RequestBody Result result) {
        System.out.println(JSON.toJSONString(result));
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setAbs(i + "Abs");
            book.setId(i);
            book.setAuthor(i + "Author");
            book.setCover("https://i.loli.net/2019/04/10/5cada7e73d601.jpg");
            book.setDate("2019-11-0" + i);
            book.setPress(i + "Press");
            book.setTitle(i + "Title");
            result.addE(book);
        }
        result.setTotal(result.getData().size());
        result.success(ResultCode.SUCCESS);
        return result;
    }
}
