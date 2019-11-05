package com.rls.springbootvue.controller;

import com.rls.springbootvue.model.User;
import com.rls.springbootvue.result.Result;
import com.rls.springbootvue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@Controller
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getSignInName();
        username = HtmlUtils.htmlEscape(username);
        return userService.selectByPassWord(username, requestUser.getPassWord());
    }
}
