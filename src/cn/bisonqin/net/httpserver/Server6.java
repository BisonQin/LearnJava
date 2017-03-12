package cn.bisonqin.net.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器并启动，版本1.2
 * 1、请求
 * 2、响应
 * 3、封装响应
 * 4、封装Request
 * 5、封装Response
 * Created by Basil on 2017/3/9.
 */
public class Server6 {

    private ServerSocket server;
    private static final String CRLF = "\r\n";      //换行符
    private static final String BLANK = " ";        //空格

    public static void main(String[] args) {
        Server6 server = new Server6();
        server.start();
    }

    /**
     * 服务器启动方法
     */
    public void start() {
        try {
            server = new ServerSocket(8888);
            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 接收客户端信息
     */
    private void receive() {
        try {
            Socket client = server.accept();

            Servlet servlet = new Servlet();
            Request request = new Request(client.getInputStream());
            Response response = new Response(client.getOutputStream());
            servlet.service(request, response);
            response.pushToClient(200);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务器停止方法
     */
    public void stop() {

    }
}
