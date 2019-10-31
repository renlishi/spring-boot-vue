package com.rls.springbootvue.dao;

import com.rls.springbootvue.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User selectById(Long id);
    User selectByPassWord(@Param("signInName")String signInName, @Param("passWord") String passWord);
}
