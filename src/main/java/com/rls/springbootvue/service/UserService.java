package com.rls.springbootvue.service;

import com.rls.springbootvue.result.Result;

public interface UserService {

    Result selectByPassWord(String signInName, String passWord);
}
