package com.rls.springbootvue.controller;

import com.rls.springbootvue.model.User;
import com.rls.springbootvue.result.Result;
import com.rls.springbootvue.result.ResultCode;
import com.rls.springbootvue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/findUser")
    public Result login(@RequestBody Result result) {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName(i + "Abs");
            user.setId(i);
            user.setProvince(i + "Author");
            user.setCity("https://i.loli.net/2019/04/10/5cada7e73d601.jpg");
            user.setDate("2019-11-0" + i);
            user.setAddress(i + "Press");
            user.setZip(i + "Title");
            result.addE(user);
        }
        result.setTotal(result.getData().size());
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMessage());
        return result;
    }
}
