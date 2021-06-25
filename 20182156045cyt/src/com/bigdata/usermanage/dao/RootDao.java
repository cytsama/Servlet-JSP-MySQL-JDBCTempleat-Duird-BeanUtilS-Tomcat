package com.bigdata.usermanage.dao;

import com.bigdata.usermanage.entity.User;

public interface RootDao {
    //查询登录信息username password
    User userLogin(User user);
    Boolean registerUser(User user);
    User register(String username);


}
