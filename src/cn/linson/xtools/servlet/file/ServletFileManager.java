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
        File fileDir = new File(path);
        if (fileDir.exists()) {
//            String[] fileNames = fileDir.list();
            File[] files = fileDir.listFiles();
            request.setAttribute("files",files);
        }
        ArrayList<FileInfo> arrayList = FileUtils.getFileInfos(fileDir);

        request.setAttribute("fileList",arrayList);

        request.getRequestDispatcher("/WEB-INF/jsp/imageManager.jsp").forward(request,response);
    }
}
