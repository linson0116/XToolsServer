package cn.linson.xtools.servlet.file;



import cn.linson.xtools.domain.FileInfo;
import cn.linson.xtools.utils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/10.
 */
public class ServletFileManager extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/files");
//        String path = "c:/temp/";
        File fileDir = new File(path);
        if (fileDir.exists()) {
            File[] files = fileDir.listFiles();
            request.setAttribute("files", files);
        } else {
            System.out.println("显示文件夹不存在：" + path);
        }
        ArrayList<FileInfo> arrayList = FileUtils.getFileInfos(fileDir);

        request.setAttribute("fileList",arrayList);

        request.getRequestDispatcher("/WEB-INF/jsp/imageManager.jsp").forward(request,response);
    }
}
