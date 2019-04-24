package com.example.spingbootmybatis.dao;

import com.example.spingbootmybatis.domain.User;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper {
    //@Insert("insert into user(name,age) values(#{name},#{age})")
    void insertUser(User user);
}
