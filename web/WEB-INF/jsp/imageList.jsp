<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>上传图片</title>
    <link rel='stylesheet' href='css/justifiedgallery.min.css' type='text/css' media='all' />
    <link rel='stylesheet' href='css/swipebox.css' type='text/css' media='screen' />
    <link rel='stylesheet' href='css/colorbox.css' type='text/css' media='screen' />
    <script src='js/jquery.min.js'></script>
    <script src='js/justifiedgallery.js'></script>
    <script src='js/jquery.swipebox.min.js'></script>
    <script src='js/jquery.colorbox-min.js'></script>
    <script>
        $(document).ready(function() {
            $('#remotetest').justifiedGallery({rel: 'gal0'}).on('jg.rowflush', function () {
                $(this).find('a').colorbox({
                    maxWidth : '100%',
                    maxHeight : '100%',
                    opacity : 0.8,
                    transition : 'elastic',
                    current : ''
                });
            });
        });
    </script>
</head>
<body>
<!-- 代码 开始 -->
<div id="remotetest"  style="border: 1px solid black;">
    <c:forEach var="fileName" items="${fileNames}">
        <a href="/XToolsServer/files/${fileName}">
            <img src="/XToolsServer/files/${fileName}" >
        </a>
    </c:forEach>
</div>
<!-- 代码 结束 -->
</body>
</html>







