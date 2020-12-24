package com.peter._05_请求转发;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Request1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/page/hello.html").forward(req, resp);
//        ServletOutputStream outputStream = resp.getOutputStream();
//        PrintWriter writer = resp.getWriter();
        //解决响应中文乱码方式一：
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-Type","text/html;charset=utf-8");
        //解决响应中文乱码方式二
        resp.setContentType("text/html;charset=utf-8");
    }
}
