package com.bigdata.usermanage.dao.impl;

import com.bigdata.usermanage.dao.RootDao;
import com.bigdata.usermanage.entity.User;
import com.bigdata.usermanage.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class RootDaoimpl implements RootDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User userLogin(User user){
        try{
            String sql = "select * from root where username = ? and password =?";
            User users = this.template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),user.getUsername(),user.getPassword());
            return users;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //添加用户，进行判断该用户是否已经存在，使名字唯一
    @Override
    public User register(String username) {
        String sql = "select * from root where username=?";
        try {
            return this.template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Boolean registerUser(User user) {
        String sql="insert into root(username,password) values(?,?)";
        int update = template.update(sql, user.getUsername(),user.getPassword());
        if (update>0){
            return true;
        }
        return null;
    }
}
