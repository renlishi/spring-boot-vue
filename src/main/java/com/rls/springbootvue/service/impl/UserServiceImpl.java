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
        User user = userDao.selectByPassWord(signInName, passWord);
        if (null == user) {
            return new Result().success(ResultCode.FAILED);
        } else {
            return new Result().success(ResultCode.SUCCESS);
        }
    }
}
