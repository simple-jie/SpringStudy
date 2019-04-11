package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * SpringBoot整合Filter方式二
 * 方法注册
 * <p>
 * 以往在web.xml中的配置方式回顾
 * <filter>
 * <filter-name>FirstFilter</filter-name>
 * <filter-class>com.example.filter.FirstFilter</filter-class>
 * </filter>
 * <p>
 * <filter-mapping>
 * <filter-name>FirstFilter</filter-name>
 * <url-pattern>/first</url-pattern>
 * </filter-mapping>
 */
public class SecondFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----------------SecondFilter init----------------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----------------SecondFilter doFilter 1 ----------------");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("----------------SecondFilter doFilter 2 ----------------");
    }

    @Override
    public void destroy() {
        System.out.println("----------------SecondFilter destroy----------------");
    }
}
