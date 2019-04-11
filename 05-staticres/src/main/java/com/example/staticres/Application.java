package com.example.staticres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 静态资源访问
 * 方法一: static目录下的资源可直接URL访问
 * 例如访问 http://127.0.0.1:8080/index.html
 *
 * 方法二: servletContext根目录下的资源访问
 * 既在src/main/webapp目录下
 * 例如: http://127.0.0.1:8080/web.html
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
