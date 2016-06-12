package cn.linson.xtools.servlet.file;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        String path = getServletContext().getRealPath("/files");
        File fileDir = new File(path);
        if (fileDir.exists()) {
            File file = new File(fileDir, fileName);
            if (file.exists()) {
                file.delete();
            }
        }
        request.getRequestDispatcher("/ServletFileManager").forward(request,response);
    }
}
