package cn.linson.xtools.servlet.file;

import cn.linson.xtools.db.MyDB;
import cn.linson.xtools.domain.ImageInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/12.
 */
public class ServletDisplayOneTypeFiles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        List<ImageInfo> fileList = null;
        MyDB myDB = new MyDB();
        if ("zxsdhxg".equals(type)) {
            fileList = myDB.findImageInfoByType("中兴SDH相关");
        } else if ("hwsdhxg".equals(type)) {
            fileList = myDB.findImageInfoByType("华为SDH相关");
        } else if ("dyjupsxg".equals(type)) {
            fileList = myDB.findImageInfoByType("电源及UPS相关");
        } else if ("whgx".equals(type)) {
            fileList = myDB.findImageInfoByType("文化共享");
        } else if ("others".equals(type)) {
            fileList = myDB.findImageInfoByType("其他");
        }
        request.setAttribute("fileList", fileList);
        request.getRequestDispatcher("/WEB-INF/jsp/imageOneTypeList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
