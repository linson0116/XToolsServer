package cn.linson.xtools.servlet.file;

import cn.linson.xtools.db.MyDB;
import cn.linson.xtools.domain.ImageInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2015/11/11.
 */

public class ServletDeleteFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        String fileType = request.getParameter("fileType");
        fileType = new String(fileType.getBytes("ISO8859-1"), "UTF-8");
        String type = "";
        if (fileType.equals("中兴SDH相关")) {
            type = "zxsdhxg";
        } else if (fileType.equals("华为SDH相关")) {
            type = "hwsdhxg";
        } else if (fileType.equals("电源及UPS相关")) {
            type = "dyjupsxg";
        } else if (fileType.equals("文化共享")) {
            type = "whgx";
        } else if (fileType.equals("其他")) {
            type = "others";
        }
        String path = getServletContext().getRealPath("/files");
        File fileDir = new File(path);
        MyDB myDB = new MyDB();
        if (fileDir.exists()) {
            File file = new File(fileDir, fileName);
            if (file.exists()) {
                ImageInfo imageInfo = myDB.findByImageName(fileName);
                myDB.delete(imageInfo);
                file.delete();
            }
        }
        request.getRequestDispatcher("/ServletDisplayOneTypeFiles?type=" + type).forward(request, response);
    }
}
