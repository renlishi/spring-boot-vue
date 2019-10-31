package com.rls.springbootvue.service.impl;

import com.rls.springbootvue.dao.UserDao;
import com.rls.springbootvue.model.User;
import com.rls.springbootvue.result.Result;
import com.rls.springbootvue.result.ResultCode;
import com.rls.springbootvue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Result selectByPassWord(String signInName, String passWord) {
        Result result;
        User user = userDao.selectByPassWord(signInName, passWord);
        if (null == user) {
            String message = "账号密码错误";
            result = new Result().successData(ResultCode.FAILED, message);
        } else {
            result = new Result().success(ResultCode.SUCCESS);
        }
        return result;
    }
}
