package com.bigdata.usermanage.dao;

import com.bigdata.usermanage.entity.User;

import java.util.List;

public interface UserDao {
    //查询用户所有
    public  List<User> findAllUser();

    //添加用户user
    User add(User user);

    //删除用户 id
    User delete(int id);

    // 根据id查询用户id
    User findById(int id);

    // 修改用户 user
    User update(User user);

}