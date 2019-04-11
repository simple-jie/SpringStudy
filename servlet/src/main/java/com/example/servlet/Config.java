package com.example.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

public class Config {

    /**
     * 方法完成servlet组件注册
     * @return
     */
    @Bean
    public ServletRegistrationBean<FirstServlet> firstServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean<>(new FirstServlet());
        bean.addUrlMappings("/first");
        return bean;
    }
}
