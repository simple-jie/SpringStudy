package com.example.spingbootmybatis.dao;

import com.example.spingbootmybatis.domain.User;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface UserMapper {
    //@Insert("insert into user(name,age) values(#{name},#{age})")
    int insertUser(User user);

    List<User> queryAllUser();

    User queryByID(Integer id);

    void delete(Integer id);

    void updateUser(User user);

}
