package com.example.viewjsp.web;

import com.example.viewjsp.domian.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    @RequestMapping("/showUsers")
    public String showUsers(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User(1,"用户已",10));
        list.add(new User(2,"用户哈",20));
        list.add(new User(3,"用户把",30));
        model.addAttribute("list", list);
        return "userList";
    }
}
