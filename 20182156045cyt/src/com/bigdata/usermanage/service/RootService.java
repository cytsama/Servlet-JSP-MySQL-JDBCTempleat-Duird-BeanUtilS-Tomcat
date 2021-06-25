package com.bigdata.usermanage.service;

import com.bigdata.usermanage.entity.User;

public interface RootService {
    //登录方法user
    User userLogin(User user);
    Boolean registerUser(User user);
}
