package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Springboot整合Listener
 *  方法
 * <p>
 * web.xml定义回顾
 * <listener>
 * <listener-class>
 * com.example.listener.FirstListener
 * </listener-class>
 * </listener>
 */
public class SecondListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("------------SecondListener contextDestroyed -----------");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("------------SecondListener contextInitialized -----------");
    }
}
