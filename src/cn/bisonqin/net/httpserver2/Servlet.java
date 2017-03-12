package cn.bisonqin.net.httpserver2;

/**
 * 抽象成一个父类
 * Created by Basil on 2017/3/11.
 */
public abstract class Servlet {

    public void service(Request request, Response response) throws Exception{
        this.doGet(request, response);
        this.doPost(request, response);
    }

    public abstract void doGet(Request request, Response response) throws Exception;
    public abstract void doPost(Request request, Response response) throws Exception;
}
