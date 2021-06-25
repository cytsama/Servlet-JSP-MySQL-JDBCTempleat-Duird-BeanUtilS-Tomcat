package com.bigdata.usermanage.service.impl;

import com.bigdata.usermanage.dao.RootDao;
import com.bigdata.usermanage.dao.impl.RootDaoimpl;
import com.bigdata.usermanage.entity.User;
import com.bigdata.usermanage.service.RootService;
import sun.security.provider.MD5;

public class RootServiceimpl implements RootService {
    @Override
    public User userLogin(User user){
        //创建dao对象，调用dao里面的方法，进行判断
        RootDao userDao =new RootDaoimpl();
        return  userDao.userLogin(user);
    }
    //判断用户是否存在
    @Override
    public Boolean registerUser(User user) {
        //user.setPassword(MD5.getPWD(user.getPassword()));
        //创建dao对象，调用dao里面的方法，进行判断
        RootDao userDao =new RootDaoimpl();
        //判断用户名是否为空
        User u=userDao.register(user.getUsername());
        if (u==null){
            userDao.registerUser(user);
            return true;
        }
        return  false;
    }
}

