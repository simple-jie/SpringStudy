package com.example.error.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @RequestMapping("/hello")
    @ResponseBody
    public Res hello() throws Exception {
//        throw new Exception("未知错误");
        return new Res("aa");
    }

    @RequestMapping("/hello1")
    public String hello1() throws MyException {
        throw new MyException("未知错误1");
    }
}
