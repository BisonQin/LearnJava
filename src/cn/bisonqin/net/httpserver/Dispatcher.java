package cn.bisonqin.net.httpserver;

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
        Servlet servlet = new Servlet();
        servlet.service(request, response);
        try {
            response.pushToClient(code);                //推送到客户端
        } catch (IOException e) {
            //e.printStackTrace();
        }

        try {
            response.pushToClient(500);
        } catch (IOException e) {
            //e.printStackTrace();
        }
        CloseUtils.closeSocket(client);
    }
}
