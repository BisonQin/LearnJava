package cn.bisonqin.net.finalserver.servlet;

import cn.bisonqin.net.finalserver.Request;
import cn.bisonqin.net.finalserver.Response;

/**
 * Created by Basil on 2017/3/11.
 */
public class LoginServlet extends Servlet {

    @Override
    public void doGet(Request request, Response response) throws Exception {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        if(login(name, password)) {
            response.println("登录成功");
        }else {
            response.println("登录失败");
        }

    }

    public boolean login(String name, String password) {
        return name.equals("bison") && password.equals("123");
    }

    @Override
    public void doPost(Request request, Response response) throws Exception {

    }
}
