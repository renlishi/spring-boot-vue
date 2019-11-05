package com.rls.springbootvue.controller;

import com.rls.springbootvue.model.Book;
import com.rls.springbootvue.result.Result;
import com.rls.springbootvue.result.ResultCode;
import com.rls.springbootvue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/books")
    public Result login(@RequestBody Result result) {
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
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMessage());
        return result;
    }
}
