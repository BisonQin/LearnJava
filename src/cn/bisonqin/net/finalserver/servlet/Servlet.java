package cn.bisonqin.net.finalserver.servlet;

import cn.bisonqin.net.finalserver.Request;
import cn.bisonqin.net.finalserver.Response;

/**
 * 抽象成一个父类
 * Created by Basil on 2017/3/11.
 */
public abstract class Servlet {

    public void service(Request request, Response response) throws Exception{
        this.doGet(request, response);
        this.doPost(request, response);
    }

    protected abstract void doGet(Request request, Response response) throws Exception;
    protected abstract void doPost(Request request, Response response) throws Exception;
}
