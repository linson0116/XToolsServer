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
    <title>首页</title>
    <style>
        body {
            background: #8cb4ef;
            text-align: center;
        }

        div {
            width: 200px;
            margin: 0 auto;
            text-align: center;
        }

        #vertical {
            position: absolute;
            width: 200px;
            height: 70px;
            left: 50%;
            top: 50%;
            margin-left: -100px;
            margin-top: -35px;
            /*border: solid 3px red;*/
        }
    </style>
</head>
<body>
<%--<a href="/XToolsServer/UserServlet">UserServlet</a>--%>
<%--<a href="/XToolsServer/LogServlet">LogServlet</a>--%>
<%--<a href="/XToolsServer/LogServlet">LogServlet</a>--%>
<%--<br>--%>
<%--<form action="/XToolsServer/ServletUpFile" method="post" enctype="multipart/form-data">--%>
<%--<input name="filename" type="file">--%>
<%--<input type="submit" value="upload">--%>
<%--</form>--%>
<%--<a href="/XToolsServer/ServletDisplayFiles">ServletDisplayFiles</a>--%>
<%--<a href="/XToolsServer/ServletFileManager">ServletFileManager</a>--%>

<div id="vertical">
    <a href="/XToolsServer/ServletDisplayFiles" style="text-decoration: none">
        <font size="100">进入系统</font>
    </a>
</div>

</body>
</html>
