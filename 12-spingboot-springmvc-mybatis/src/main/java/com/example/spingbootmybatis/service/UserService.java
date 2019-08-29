package com.example.spingbootmybatis.service;

import com.example.spingbootmybatis.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> queryAllUser();

    User queryByID(Integer id);

    void editUser(User user);

    void delete(Integer id);

    void testTransactional(User user);
}
