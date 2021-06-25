package com.bigdata.usermanage.service;

import com.bigdata.usermanage.entity.User;

import java.util.List;

public interface UserService {
    //查用户信息
    public List<User> getAllUser();



    //存对象 user
    User addUser(User user);

    //根据id删除user
    User deleteUser(String id);

    //根据id查询 id
    User findUserById(String id);

    //修改用户信息 user
    void updateUser(User user);
}
