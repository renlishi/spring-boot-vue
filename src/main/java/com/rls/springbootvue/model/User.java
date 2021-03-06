package com.rls.springbootvue.model;

import lombok.Data;

@Data
public class User extends BaseBean{
    int id;
    /**登录名*/
    String signInName;
    /**用户名*/
    String userName;
    /**密码*/
    String passWord;
    String date;
    String name;
    String province;
    String city;
    String address;
    String zip;
}
