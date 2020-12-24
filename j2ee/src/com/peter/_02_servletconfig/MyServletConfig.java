package com.peter._02_servletconfig;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 每个Servlet对象拥有自己的ServletConfig对象。
 * 可以从中获取xml配置文件中<init-param></init-param>中的参数
 */
public class MyServletConfig extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig cfg = getServletConfig();
        System.out.println(cfg.getInitParameter("name"));
        System.out.println(cfg.getInitParameter("age"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletConfig cfg = getServletConfig();
//        System.out.println(cfg.getInitParameter("name"));
//        System.out.println(cfg.getInitParameter("age"));
    }
}
