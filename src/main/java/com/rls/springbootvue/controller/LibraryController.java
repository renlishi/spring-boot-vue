package com.rls.springbootvue.controller;

import com.rls.springbootvue.model.Book;
import com.rls.springbootvue.result.Result;
import com.rls.springbootvue.result.ResultCode;
import com.rls.springbootvue.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
    @Autowired
    private BookService bookService;

    @CrossOrigin
    @PostMapping("/books")
    public Result index(@RequestBody Book condition) {
        List<Book> list = bookService.selectByCondition(condition);
        Result result = new Result();
        result.setData(list);
        result.setTotal(bookService.getTotal(condition));
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMessage());
        return result;
    }
}
