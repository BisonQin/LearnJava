package cn.bisonqin.net.httpserver3;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文
 * Created by Basil on 2017/3/11.
 */
public class ServletContext {

    //为每一个Servlet取个别名
    //login   ---> netdemo.httpserver3.LoginServlet
    private Map<String, String> servelet;       //用对象的话，耗性能
    //url  -->login
    //  /log    -->login
    //  /login  -->login
    private Map<String, String> mapping;

    public ServletContext() {
        this.servelet = new HashMap<>();
        this.mapping = new HashMap<>();
    }

    public Map<String, String> getServelet() {
        return servelet;
    }

    public void setServelet(Map<String, String> servelet) {
        this.servelet = servelet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
