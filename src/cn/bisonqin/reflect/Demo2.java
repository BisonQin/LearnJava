package cn.bisonqin.reflect;

import cn.bisonqin.net.httpserver3.Servlet;

/**
 * 创建实例，调用空构造器
 * Created by Basil on 2017/3/12.
 */
public class Demo2 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> cla = Class.forName("net.httpserver3.LoginServlet");
        //调用空构造，确保空构造存在
        Servlet servlet = (Servlet)cla.newInstance();

    }
}
