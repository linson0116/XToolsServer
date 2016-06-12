package cn.linson.xtools.servlet;

import cn.linson.xtools.db.MyDB;
import cn.linson.xtools.domain.User;
import cn.linson.xtools.utils.ReturnMessage;
import cn.linson.xtools.utils.SendFlag;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/5/4.
 */
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserServlet doPost1");
        String data = request.getParameter("data");
        String sendFlag = request.getParameter("sendFlag");
        System.out.println("sendFlag=" + sendFlag + " " + "data=" + data);
        if (SendFlag.USER_LOGIN.equals(sendFlag)) {
            MyDB myDB = new MyDB();
            Gson gson = new Gson();
            User user = gson.fromJson(data, User.class);
            User returnUser = myDB.find(user);

            if (null != returnUser) {
                response.getOutputStream().print(ReturnMessage.LOGIN_OK);
            } else {
                response.getOutputStream().print(ReturnMessage.LOGIN_FALSE);
            }
        } else {
            if (null != data && !"".equals(data)) {
                Gson gson = new Gson();
                User user = gson.fromJson(data, User.class);
                MyDB myDB = new MyDB();
                myDB.add(user);
                response.getOutputStream().print(ReturnMessage.REGIST_OK);
            } else {
                response.getOutputStream().print(ReturnMessage.REGIST_ERROR);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
