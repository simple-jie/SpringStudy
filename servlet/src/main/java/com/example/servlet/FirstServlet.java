package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring web.xml中对servlet的配置
 *
 * <servlet>
 * <servlet-name>FirstServlet</servlet-name>
 * <servlet-class>com.example.servlet.FirstServlet</servlet-class>
 * <servlet/>
 * <servlet-mapping>
 * <servlet-name>FirstServlet</servlet-name>
 * <url-pattern>first</url-pattern>
 * <servlet-mapping/>
 */
@WebServlet(
        name = "FirstServlet",
        urlPatterns = "/first"
)
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("First Servlet");
        resp.setStatus(200);
    }
}
