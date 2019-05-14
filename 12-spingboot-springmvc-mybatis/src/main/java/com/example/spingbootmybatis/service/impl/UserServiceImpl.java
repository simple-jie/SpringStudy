package com.example.spingbootmybatis.service.impl;

import com.example.spingbootmybatis.dao.UserMapper;
import com.example.spingbootmybatis.domain.User;
import com.example.spingbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        System.out.println("============== addUser " + user.toString());
        userMapper.insertUser(user);
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public User queryByID(Integer id) {
        return userMapper.queryByID(id);
    }

    @Override
    public void editUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }
}
