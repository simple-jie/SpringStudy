package com.example.spingbootmybatis.controller;

import com.example.spingbootmybatis.domain.User;
import com.example.spingbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    @RequestMapping("addUser")
    public String addUser(User user) {
        this.userService.addUser(user);
        return "ok";
    }

    @RequestMapping("showAllUser")
    public String showAllUser(Model model) {
        List<User> users = userService.queryAllUser();
        model.addAttribute("users", users);
        return "showUsers";
    }

    @RequestMapping("queryAll")
    @ResponseBody
    public List<User> queryAll() {
        return userService.queryAllUser();
    }

    @RequestMapping("/query/{id}")
    @ResponseBody
    public User queryByID(@PathVariable Integer id) {
        return userService.queryByID(id);
    }

    @RequestMapping("/update/{id}")
    public String queryByID(@PathVariable Integer id, Model model) {
        User user = userService.queryByID(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @RequestMapping("/updateByID")
    public String updateByID(Integer id, Model model) {
        User user = userService.queryByID(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @RequestMapping("edit")
    public String editUser(User user) {
        this.userService.editUser(user);
        return "ok";
    }

    @RequestMapping(value = "delete")
    public String deleteUser(Integer id) {
        this.userService.delete(id);
        return "ok";
    }
}


