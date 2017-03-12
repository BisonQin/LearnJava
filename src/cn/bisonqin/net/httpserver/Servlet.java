package cn.bisonqin.net.httpserver;

/**
 * Created by Basil on 2017/3/11.
 */
public class Servlet {

    public void service(Request request, Response response) {
        response.println("<html><head><title>HTTP响应示例</title></head><body>");
        response.println("欢迎：").println(request.getParameter("username")).println("回来");
        response.println("</body></html>");
    }
}
