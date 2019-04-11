package com.example.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecondServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondServletApplication.class, args);
    }


    /**
     * 方法完成servlet组件注册
     * @see Config#firstServletBean()
     */
    @Bean
    public ServletRegistrationBean<SecondServlet> secondServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean<>(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }
}
