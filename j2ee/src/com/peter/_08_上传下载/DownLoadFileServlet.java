package com.peter._08_上传下载;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class DownLoadFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletContext().getRealPath("/upload");
        String fileName = "news.jpg";

        //获取要下载的文件类型
       String mimeType =  getServletContext().getMimeType(fileName);
       //返回前告诉浏览器返回的数据类型
       resp.setContentType(mimeType);

       //告诉浏览器这将是一个附件，如果不做该设置，就会直接显示在浏览器上
        resp.setHeader("Content-Disposition", "attachment;filename="+fileName);



        IOUtils.copy(req.getServletContext().getResourceAsStream("/upload/"+fileName),resp.getOutputStream());
    }
}
