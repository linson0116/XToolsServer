package cn.linson.xtools.servlet.file;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/9.
 */
public class ServletDisplayFiles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/files");
        File fileDir = new File(realPath);
        String[] fileNames = fileDir.list();
//        for (int i = 0; i < fileNames.length; i++) {
//            System.out.println(fileNames[i]);
//        }
        request.setAttribute("fileNames",fileNames);
        request.getRequestDispatcher("/WEB-INF/jsp/imageList.jsp").forward(request,response);
    }
}
