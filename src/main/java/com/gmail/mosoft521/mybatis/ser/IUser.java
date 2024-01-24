package com.gmail.mosoft521.mybatis.ser;

import com.gmail.mosoft521.mybatis.pojo.User;

import java.util.List;

public interface IUser {
    public List<User> queryUsers();

    public User queryUserById(int id);
}