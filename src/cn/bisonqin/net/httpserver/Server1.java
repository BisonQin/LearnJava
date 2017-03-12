package net.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器并启动，版本1.0
 * （能看到get请求方式的请求信息）
 * Created by Basil on 2017/3/9.
 */
public class Server1 {

    private ServerSocket server;

    public static void main(String[] args) {
        Server1 server = new Server1();
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
            StringBuilder sb = new StringBuilder();
            String msg = null;          //接收客户端的请求信息

            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while((msg = br.readLine()).length() > 0) {
                sb.append(msg);
                sb.append("\n");
                if(null == msg) {
                    break;
                }
            }
            System.out.println(sb.toString());
            //接收客户端请求信息
            String requireInfo = sb.toString().trim();

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
