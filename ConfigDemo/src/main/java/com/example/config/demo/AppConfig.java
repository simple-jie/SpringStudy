package com.example.config.demo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
@Data
@NoArgsConstructor
public class AppConfig {
    private String name;
    private String uuid;
    private String value;
    private int max;
    private String greeting;
}
