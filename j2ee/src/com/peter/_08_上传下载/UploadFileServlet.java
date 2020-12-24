package com.peter._08_上传下载;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class UploadFileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
//        System.out.println("here");
//        ServletInputStream inputStream = req.getInputStream();
//
//        byte[] stream = new byte[1000000];
//        int size = inputStream.read(stream);
//        String str = new String(stream, 0, size);
//        System.out.println(str);
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> list = upload.parseRequest(req);

            for (FileItem fileItem : list) {
                //判断是否是普通表单项
                if(fileItem.isFormField()){
                    System.out.println(fileItem.getFieldName());
//                    System.out.println(fileItem.getString(fileItem.getFieldName()));
                }else{
                    System.out.println(fileItem.getName());
                    String path = req.getServletContext().getRealPath("/upload");
                    System.out.println(path);
                    fileItem.write(new File(path,fileItem.getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
