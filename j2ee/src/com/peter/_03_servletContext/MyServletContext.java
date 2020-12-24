package com.peter._03_servletContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext只有一个，在Tomcat启动时创建，在Tomcat关闭时销毁
 * 可以获取<context-param></context-param>中的参数
 * 所有Servlet都可以获取ServletContext中的数据
 */
public class MyServletContext extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        ServletContext ctx = req.getServletContext();

        System.out.println("获取上下文参数："+ctx.getInitParameter("year"));
        System.out.println("获取工程的相对路径："+ ctx.getContextPath());
//        WEB-INF的绝对路径，也可以获取项目中某文件的绝对路径
        System.out.println("获取工程的绝对路径："+ ctx.getRealPath("/"));
        System.out.println(ctx.getRealPath("/a"));

        ctx.setAttribute("name","Peter");

        System.out.println(ctx.getAttribute("name"));
    }
}
