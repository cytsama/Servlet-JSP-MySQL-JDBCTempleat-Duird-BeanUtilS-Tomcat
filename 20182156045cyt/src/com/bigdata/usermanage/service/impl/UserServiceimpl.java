package com.bigdata.usermanage.service.impl;

import com.bigdata.usermanage.dao.UserDao;
import com.bigdata.usermanage.dao.impl.UserDaoimpl;
import com.bigdata.usermanage.entity.User;
import com.bigdata.usermanage.service.UserService;

import java.util.List;

public class UserServiceimpl implements UserService {
    private UserDao userDao = new UserDaoimpl();
    @Override
    public List<User> getAllUser() {
        //见对象
        //UserDao userDao = new UserDaoimpl();  //反正都要用，直接改为实例变量用private修饰
        //调用dao查询
        List<User> allUser = userDao.findAllUser();
        return allUser;
    }


    @Override
    public User addUser(User user) {
        //UserDao userDao = new UserDaoimpl();
        //List<User> add = userDao.add(user);
        return userDao.add(user);
    }

    @Override
    public User deleteUser(String id) {
        //List<User> delete = userDao.delete(id);
        return userDao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        User findById = userDao.findById(Integer.parseInt(id));
        return findById;
    }

    @Override
    public void updateUser(User user) {

        User updata = userDao.update(user);
    }

}
