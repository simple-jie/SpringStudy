package com.example.spingbootmybatis.controller;

import com.example.spingbootmybatis.domain.User;
import com.example.spingbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(">>>>>>>>>>>>>>>>>>>> /update/{id} " + user.hashCode());
        return "updateUser";
    }

    @RequestMapping("/updateByID")
    public String updateByID(Integer id, Model model) {
        User user = userService.queryByID(id);
        model.addAttribute("user", user);
        System.out.println(">>>>>>>>>>>>>>>>>>>> updateByID " + user.hashCode());
        return "updateUser";
    }

    @RequestMapping("edit")
    public String editUser(User user) {
        this.userService.editUser(user);
        System.out.println(">>>>>>>>>>>>>>>>>>>> editUser " + user.hashCode());
        return "ok";
    }

    @RequestMapping(value = "deleteByID")
    public String deleteUser(Integer id) {
        this.userService.delete(id);
        return "ok";
    }

    @RequestMapping(value = "transactional")
    public String testTransactional(@RequestBody User user) {


        try {
            this.userService.testTransactional(user);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "ok";
    }
}


