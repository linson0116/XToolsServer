<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>OneType</title>
    <style type="text/css">
        .trstyle tr {
            background-color: #d4e5ef;
        }
    </style>
</head>
<body>
<div><a href="/XToolsServer/ServletDisplayFiles">首页</a></div>
<div style="border: 0px solid black;">
    <table>
        <c:forEach var="imageInfo" items="${fileList}" varStatus="status">
            <c:if test="${status.count eq 1 || (status.count-1) % 9 eq 0}">
                <tr>
            </c:if>
            <td>
                <table class="trstyle">
                    <tr>
                        <td align="center">${imageInfo.type}</td>
                    </tr>
                    <tr>
                        <td align="center"><img src="/XToolsServer/files/${imageInfo.fileName}" width="200"
                                                height="200"></td>
                    </tr>
                    <tr>
                        <td align="center">${imageInfo.date}</td>
                    </tr>
                    <tr>
                        <td align="center">${imageInfo.comments}</td>
                    </tr>
                    <tr>
                        <td align="center">
                                ${imageInfo.userName}
                            &nbsp;&nbsp;&nbsp;&nbsp;<a
                                href="/XToolsServer/ServletDeleteFile?fileName=${imageInfo.fileName}&fileType=${imageInfo.type}">删除</a>
                        </td>
                    </tr>
                </table>

            </td>
            <c:if test="${status.count % 9 eq 0 || status.count eq 9}">
                </tr>
            </c:if>
        </c:forEach>
    </table>
</div>
</body>
</html>
