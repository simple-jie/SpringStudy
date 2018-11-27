package com.example.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {
    @Autowired
    SimpleProperty property;

    @RequestMapping("/test")
    public String test() {
        System.out.println(property.getDescription());
        System.out.println(property.getRandomInt10to20());
        System.out.println(property.getRandomValue());
        System.out.println(property.getRandomInt());
        return property.getDescription();
    }

}
