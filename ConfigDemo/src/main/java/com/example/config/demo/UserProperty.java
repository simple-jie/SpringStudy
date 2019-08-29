package com.example.config.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource(value = "classpath:user.properties")
@ConfigurationProperties(prefix = "com.userp")
// yml 格式文件无法正常读？原因未知
//@PropertySource(value = "classpath:user.yml")
//@ConfigurationProperties(prefix = "com.usery")
public class UserProperty {
    private String name;
    private int age;
    private int height;
}
