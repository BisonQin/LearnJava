package cn.bisonqin.net.httpserver2;

import java.util.Map;

/**
 * Created by Basil on 2017/3/11.
 */
public class WebApp {

    private static ServletContext context;

    static {
        context = new ServletContext();
        Map<String, String> mapping = context.getMapping();
        mapping.put("/login", "login");
        mapping.put("/log", "login");
        mapping.put("/register", "register");
        mapping.put("/reg", "register");

        Map<String, Servlet> servlet = context.getServelet();
        servlet.put("login", new LoginServlet());
        servlet.put("register", new RegisterServlet());
    }

    public static Servlet getServlet(String url) {
        if(null == url || url.trim().equals("")) {
            return null;
        }
        return context.getServelet().get(context.getMapping().get(url));
    }
}
