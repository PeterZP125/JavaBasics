<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <% String basePath = request.getScheme()+"://"+
                          request.getServerName()+":"+
                          request.getServerPort()+
                          request.getContextPath()+"/";
    %>
    <%= basePath%><br/>
    <%= request.getServletContext().getContextPath()%><br/>
    <%= request.getContextPath()%>
  </head>
  <body>
  <a href="a/b/base.html">base.html</a>
  <a href="http://localhost/j2ee/base">base</a>
  </body>
</html>
