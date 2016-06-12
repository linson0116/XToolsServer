package cn.linson.xtools.servlet.file;



import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/6.
 */
public class ServletUpFile extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            String realPath = getServletContext().getRealPath("/files");
            File fileDir = new File(realPath);
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("utf-8");
            try {
                List<FileItem> items = upload.parseRequest(request);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        String filed = item.getString();
                        System.out.println(filed);

                    } else {
                        String fileName = item.getName();
                        int position = fileName.lastIndexOf("\\");
                        String temp = fileName.substring(position+1);
                        System.out.println(temp);
                        item.write(new File(fileDir, temp));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/XToolsServer/ServletDisplayFiles");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
