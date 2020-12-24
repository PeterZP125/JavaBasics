<%--
  Created by IntelliJ IDEA.
  User: Zhang
  Date: 2020/11/5
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/j2ee/upload" method="post" enctype="multipart/form-data">
        <input type="text" name="name" value="Peter"><br/>
        <input type="file" name="img"><br/>
        <input type="submit" value="submit">
    </form>
</body>
</html>
