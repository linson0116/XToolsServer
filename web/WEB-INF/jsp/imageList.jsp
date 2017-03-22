<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>数据列表</title>
    <link rel='stylesheet' href='css/justifiedgallery.min.css' type='text/css' media='all'/>
    <link rel='stylesheet' href='css/swipebox.css' type='text/css' media='screen'/>
    <link rel='stylesheet' href='css/colorbox.css' type='text/css' media='screen'/>
    <script src='js/jquery.min.js'></script>
    <script src='js/justifiedgallery.js'></script>
    <script src='js/jquery.swipebox.min.js'></script>
    <script src='js/jquery.colorbox-min.js'></script>
    <script>
        $(document).ready(function () {
            $('#remotetest').justifiedGallery({rel: 'gal0'}).on('jg.rowflush', function () {
                $(this).find('a').colorbox({
                    maxWidth: '100%',
                    maxHeight: '100%',
                    opacity: 0.8,
                    transition: 'elastic',
                    current: ''
                });
            });
        });
    </script>
    <style type="text/css">
        .trstyle tr {
            background-color: #d4e5ef;
        }
    </style>
</head>
<body>
<!-- 代码 开始 id="remotetest"  -->
<div style="border: 0px solid black;">
    <table class="trstyle">
        <tr>
            <c:forEach var="imageInfo" items="${zxsdhxg}">
                <td align="center">${imageInfo.type}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${zxsdhxg}">
                <td align="center">
                    <img src="/XToolsServer/files/${imageInfo.fileName}" width="200" height="200">
                </td>
            </c:forEach>
            <td>
                <a href="/XToolsServer/ServletDisplayOneTypeFiles?type=zxsdhxg">更 多</a>
            </td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${zxsdhxg}">
                <td align="center">${imageInfo.date}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${zxsdhxg}">
                <td align="center">${imageInfo.comments}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${zxsdhxg}">
                <td align="center">${imageInfo.userName}</td>
            </c:forEach>
            <td></td>
        </tr>
    </table>
</div>
<div style="border: 0px solid black;">
    <table class="trstyle">
        <tr>
            <c:forEach var="imageInfo" items="${hwsdhxg}">
                <td align="center">${imageInfo.type}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${hwsdhxg}">
                <td align="center">
                    <img src="/XToolsServer/files/${imageInfo.fileName}" width="200" height="200">
                </td>
            </c:forEach>
            <td>
                <a href="/XToolsServer/ServletDisplayOneTypeFiles?type=hwsdhxg">更 多</a>
            </td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${hwsdhxg}">
                <td align="center">${imageInfo.date}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${hwsdhxg}">
                <td align="center">${imageInfo.comments}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${hwsdhxg}">
                <td align="center">${imageInfo.userName}</td>
            </c:forEach>
            <td></td>
        </tr>
    </table>
</div>
<div style="border: 0px solid black;">
    <table class="trstyle">
        <tr>
            <c:forEach var="imageInfo" items="${dyjupsxg}">
                <td align="center">${imageInfo.type}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${dyjupsxg}">
                <td align="center">
                    <img src="/XToolsServer/files/${imageInfo.fileName}" width="200" height="200">
                </td>
            </c:forEach>
            <td>
                <a href="/XToolsServer/ServletDisplayOneTypeFiles?type=dyjupsxg">更 多</a>
            </td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${dyjupsxg}">
                <td align="center">${imageInfo.date}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${dyjupsxg}">
                <td align="center">${imageInfo.comments}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${dyjupsxg}">
                <td align="center">${imageInfo.userName}</td>
            </c:forEach>
            <td></td>
        </tr>
    </table>
</div>
<div style="border: 0px solid black;">
    <table class="trstyle">
        <tr>
            <c:forEach var="imageInfo" items="${whgx}">
                <td align="center">${imageInfo.type}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${whgx}">
                <td align="center">
                    <img src="/XToolsServer/files/${imageInfo.fileName}" width="200" height="200">
                </td>
            </c:forEach>
            <td>
                <a href="/XToolsServer/ServletDisplayOneTypeFiles?type=whgx">更 多</a>
            </td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${whgx}">
                <td align="center">${imageInfo.date}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${whgx}">
                <td align="center">${imageInfo.comments}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${whgx}">
                <td align="center">${imageInfo.userName}</td>
            </c:forEach>
            <td></td>
        </tr>
    </table>
</div>
<div style="border: 0px solid black;">
    <table class="trstyle">
        <tr>
            <c:forEach var="imageInfo" items="${others}">
                <td align="center">${imageInfo.type}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${others}">
                <td align="center">
                    <img src="/XToolsServer/files/${imageInfo.fileName}" width="200" height="200">
                </td>
            </c:forEach>
            <td>
                <a href="/XToolsServer/ServletDisplayOneTypeFiles?type=others">更 多</a>
            </td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${others}">
                <td align="center">${imageInfo.date}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${others}">
                <td align="center">${imageInfo.comments}</td>
            </c:forEach>
            <td></td>
        </tr>
        <tr>
            <c:forEach var="imageInfo" items="${others}">
                <td align="center">${imageInfo.userName}</td>
            </c:forEach>
            <td></td>
        </tr>
    </table>
</div>
<!-- 代码 结束 -->


</body>
</html>







