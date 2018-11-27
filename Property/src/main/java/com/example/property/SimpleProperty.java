package com.example.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class SimpleProperty {


    @Value("${com.example.property.name}") //对应application.properties中的属性
    private String name;

    @Value("${com.example.property.desc}")
    private String description;

    @Value("${com.example.property.int}")
    private String randomInt;

    @Value("${com.example.property.value}")
    private String randomValue;

    @Value("${com.example.property.int10_20}")
    private String randomInt10to20;
}
