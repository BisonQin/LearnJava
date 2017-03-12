package cn.bisonqin.net.httpserver3;

/**
 * Created by Basil on 2017/3/11.
 */
public class RegisterServlet extends Servlet {
    @Override
    public void doGet(Request request, Response response) throws Exception {

    }

    @Override
    public void doPost(Request request, Response response) throws Exception {
        response.println("<html><head><title>注册界面</title></head><body>");
        response.println("你的用户名为：").println(request.getParameter("username"));
        response.println("</body></html>");
    }
}
