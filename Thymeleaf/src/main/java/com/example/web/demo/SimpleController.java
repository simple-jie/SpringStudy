package com.example.web.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://www.simple-jie.com");
        map.addAttribute("title", "测试页面");
        return "index";
    }
}
