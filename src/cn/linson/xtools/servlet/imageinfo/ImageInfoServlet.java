package cn.linson.xtools.servlet.imageinfo;

import cn.linson.xtools.db.MyDB;
import cn.linson.xtools.domain.ImageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 */
public class ImageInfoServlet extends HttpServlet {
    //app端上传数据库信息到服务端数据库
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ImageInfoServlet doGet");
        String data = request.getParameter("data");
        String datas = request.getParameter("datas");
        if (null != data && !"".equals(data)) {
            data = new String(data.getBytes("ISO8859-1"), "UTF-8");
            Gson gson = new Gson();
            ImageInfo imageInfo = gson.fromJson(data, ImageInfo.class);
            MyDB db = new MyDB();
            db.add(imageInfo);
            //response.getOutputStream().print(ReturnMessage.LOG_OK);
        }
        if (null != datas && !"".equals(datas)) {
            datas = new String(datas.getBytes("ISO8859-1"), "UTF-8");
            Gson gson = new Gson();
            List<ImageInfo> list = gson.fromJson(datas, new TypeToken<List<ImageInfo>>() {
            }.getType());
            System.out.println("size = " + list.size());
            MyDB db = new MyDB();
            for (int i = 0; i < list.size(); i++) {
                db.add(list.get(i));
            }
        }
        System.out.println(datas);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
