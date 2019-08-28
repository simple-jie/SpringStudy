package com.example.mybatisplus.controller;


import com.example.mybatisplus.dao.entity.User;
import com.example.mybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xingbo.jie
 * @since 2019-05-23
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @ResponseBody
    @GetMapping("/all")
    public List<User> users() {
        return userService.list();
    }

    @RequestMapping("addUser")
    public String addUser(User user) {
        userService.save(user);
        return "ok";
    }
}
