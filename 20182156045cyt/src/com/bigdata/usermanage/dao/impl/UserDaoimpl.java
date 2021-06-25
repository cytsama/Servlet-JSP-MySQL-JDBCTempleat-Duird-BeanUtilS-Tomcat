package com.bigdata.usermanage.dao.impl;

import com.bigdata.usermanage.dao.UserDao;
import com.bigdata.usermanage.entity.User;
import com.bigdata.usermanage.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoimpl implements UserDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAllUser() {
        //使用JDBC操作数据库
        //1.定义sql
        String sql = "select * from user ";
        //执行sql
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;

    }


    //增
    @Override
    public User add(User user) {
        //定义sql
        String sql = "insert into user values(null,?,?,?,?,?,?)";
        //执行sql
        jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());

        return null;
    }
    //删
    @Override
    public User delete(int id) {
        //定义sql
        String sql = "delete from user where id = ?";
        //执行
        jdbcTemplate.update(sql,id);
        return null;
    }
    //查
    @Override
    public User findById(int id) {
        //定义sql
        String sql = "select * from user where id = ?";
        //执行
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }
    //改
    @Override
    public User update(User user) {
        //定义sql
        String sql = "update user set name = ?,gender = ?,age = ?, address = ?,qq = ?,email = ? where id = ?";
        //执行
        jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
        return user;
    }
}
