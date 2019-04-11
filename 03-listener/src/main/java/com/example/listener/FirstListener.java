package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Springboot整合Listener
 * 注解
 * <p>
 * web.xml定义回顾
 * <listener>
 * <listener-class>
 * com.example.listener.FirstListener
 * </listener-class>
 * </listener>
 */
@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("------------FirstListener contextDestroyed -----------");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("------------FirstListener contextInitialized -----------");
    }
}
