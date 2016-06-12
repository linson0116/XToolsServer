package cn.linson.xtools.servlet;

import cn.linson.xtools.db.MyDB;
import cn.linson.xtools.domain.XtoolsLog;
import cn.linson.xtools.utils.ReturnMessage;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/5/17.
 */
public class LogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LogServlet doPost");
        String data = request.getParameter("data");
        if (null != data && !"".equals(data)) {
            data = new String(data.getBytes("ISO8859-1"),"UTF-8");
            Gson gson = new Gson();
            XtoolsLog xtoolsLog = gson.fromJson(data, XtoolsLog.class);
            System.out.println("LogServlet id "+xtoolsLog.getId());
            System.out.println("LogServlet date "+xtoolsLog.getDate());
            System.out.println("LogServlet content "+xtoolsLog.getContent());
            MyDB db = new MyDB();
            db.add(xtoolsLog);
            response.getOutputStream().print(ReturnMessage.LOG_OK);
        }
        System.out.println("LogServlet over");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
