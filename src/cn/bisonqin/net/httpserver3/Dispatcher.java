package cn.bisonqin.net.httpserver3;

import java.io.IOException;
import java.net.Socket;

/**
 * 一个请求和一个对应一个Dispatcher
 * Created by Basil on 2017/3/11.
 */
public class Dispatcher implements Runnable{

    private Socket client;
    private Request request;
    private Response response;
    private int code = 200;

    public Dispatcher(Socket client) {
        this.client = client;
        try {
            this.request = new Request(client.getInputStream());
            this.response = new Response(client.getOutputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            this.code = 500;
            return ;
        }
    }

    @Override
    public void run() {
        Servlet servlet = null;
        try {
            servlet = WebApp.getServlet(request.getUrl());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        try {
            if (null == servlet) {
                this.code = 404;                            //找不到资源处理
            } else {
                servlet.service(request, response);
            }
            response.pushToClient(code);
        } catch (Exception e) {
            //e.printStackTrace();
            this.code = 500;
        }

        try {
            response.pushToClient(500);                //推送到客户端
        } catch (IOException e) {
            //e.printStackTrace();
        }
        CloseUtils.closeSocket(client);
    }
}
