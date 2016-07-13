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
 * Created by Administrator on 2015/11/9.
 */
public class ServletDisplayFiles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String realPath = request.getSession().getServletContext().getRealPath("/files");
//        File fileDir = new File(realPath);
//        String[] fileNames = fileDir.list();
//        for (int i = 0; i < fileNames.length; i++) {
//            System.out.println(fileNames[i]);
//        }
        int displayNum = 9;
        MyDB myDB = new MyDB();
        List<ImageInfo> zxsdhxg = myDB.findImageInfoByType("中兴SDH相关", displayNum);
        request.setAttribute("zxsdhxg", zxsdhxg);

        List<ImageInfo> hwsdhxg = myDB.findImageInfoByType("华为SDH相关", displayNum);
        request.setAttribute("hwsdhxg", hwsdhxg);

        List<ImageInfo> dyjupsxg = myDB.findImageInfoByType("电源及UPS相关", displayNum);
        request.setAttribute("dyjupsxg", dyjupsxg);

        List<ImageInfo> whgx = myDB.findImageInfoByType("文化共享", displayNum);
        request.setAttribute("whgx", whgx);

        List<ImageInfo> others = myDB.findImageInfoByType("其他", displayNum);
        request.setAttribute("others", others);

        request.getRequestDispatcher("/WEB-INF/jsp/imageList.jsp").forward(request,response);
    }
}
