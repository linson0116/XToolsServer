<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/4
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<a href="/XToolsServer/UserServlet">UserServlet</a>
<a href="/XToolsServer/LogServlet">LogServlet</a>
<a href="/XToolsServer/LogServlet">LogServlet</a>
<br>
<form action="/XToolsServer/ServletUpFile" method="post" enctype="multipart/form-data">
    <input name="filename" type="file">
    <input type="submit" value="upload">
</form>
<a href="/XToolsServer/ServletDisplayFiles">ServletDisplayFiles</a>
<a href="/XToolsServer/ServletFileManager">ServletFileManager</a>
</body>
</html>
