package com.example.spingbootmybatis.service.impl;

import com.example.spingbootmybatis.dao.UserMapper;
import com.example.spingbootmybatis.domain.User;
import com.example.spingbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        System.out.println("============== userMapper = " + (userMapper.hashCode()));
        userMapper.insertUser(user);
    }
}
