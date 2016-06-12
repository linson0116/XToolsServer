<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/11/10
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        .img{
            width: 250px;height: 250px;
            border: 1px;
            border-style: solid;
            border-color:#21c6ef;
            vertical-align: middle;
            display:table-cell;
        }
    </style>
</head>
<body>
<center>
    <div style="display: table-cell;text-align: center;">
        <c:forEach var="file" items="${fileList}" varStatus="status">
            <div style="float: left">
                <div class="img">
                    <img src="/XToolsServer/files/${file.getName()}" width="${file.getNewWidth()}" height="${file.getNewHeight()}">
                        <%--<img src="/XToolsServer/files/${file.getName()}" width="400" height="400">--%>
                </div>
                <div style="text-align: center">
                    ${file.getName()}&nbsp;&nbsp;<a href="/XToolsServer/ServletDeleteFile?fileName=${file.getName()}">删除</a>
                </div>
            </div>
            <c:if test="${(status.index+1)%5==0}">
                <div style="clear: both"></div>
            </c:if>
        </c:forEach>
    </div>
</center>

</body>
</html>
