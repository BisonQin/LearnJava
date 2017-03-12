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
public class Server5 {

    private ServerSocket server;
    private static final String CRLF = "\r\n";      //换行符
    private static final String BLANK = " ";        //空格

    public static void main(String[] args) {
        Server5 server = new Server5();
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

            //请求
            Request request = new Request(client.getInputStream());

            //响应
            Response response = new Response(client.getOutputStream());
            response.println("<html><head><title>HTTP响应示例</title></head><body>");
            response.println("欢迎：").println(request.getParameter("username")).println("回来");
            response.println("</body></html>");
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
