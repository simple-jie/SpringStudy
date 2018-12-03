package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, String  pwd) {
        jdbcTemplate.update("INSERT INTO t_user(user_name, password) values(?,?)", name, pwd);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE FROM t_user WHERE user_name=?", name);
    }

    @Override
    public Integer getUserCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(user_id) FROM t_user", Integer.class);
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM t_user");
    }
}
