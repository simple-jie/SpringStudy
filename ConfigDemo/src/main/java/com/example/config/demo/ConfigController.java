package com.example.config.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ConfigController {
    @Autowired
    AppConfig config;

    @Autowired
    UserProperty userProperty;

    @Value("${app.uuid}")
    String uuid;

    @RequestMapping("/name")
    public String test() {
        return  config.getName()
                + "\nvalue>" + config.getValue()
                + "\nuuid>" + config.getUuid()
                + "\nmax>" + config.getMax()
                ;
    }

    @RequestMapping("/user")
    public String user() {
        return userProperty.getName() + " >> " + userProperty.getAge() + " >> " + userProperty.getHeight();
    }


}
