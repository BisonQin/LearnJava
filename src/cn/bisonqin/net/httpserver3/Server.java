package cn.bisonqin.net.httpserver3;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 创建服务器并启动，版本1.2
 * 1、请求
 * 2、响应
 * 3、封装响应
 * 4、封装Request
 * 5、封装Response
 * 6、多请求处理
 * 7、多请求处理——多态
 * 8、多请求处理——反射
 * 9、封装XML配置文件
 * Created by Basil on 2017/3/9.
 */
public class Server {

    private ServerSocket server;
    private static final String CRLF = "\r\n";      //换行符
    private static final String BLANK = " ";        //空格
    private boolean isRunning = true;

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    /**
     * 服务器启动方法
     */
    public void start() {
        start(8888);
    }

    /**
     * 指定端口的服务器启动方法
     */
    public void start(int port) {
        try {
            server = new ServerSocket(port);
            this.receive();
        } catch (IOException e) {
            //e.printStackTrace();
            stop();
        }
    }

    /**
     * 接收客户端信息
     */
    private void receive() {
        try {
            while(isRunning) {
                new Thread(new Dispatcher(server.accept())).start();
            }
        } catch (IOException e) {
            //e.printStackTrace();
            stop();
        }
    }

    /**
     * 服务器停止方法
     */
    public void stop() {
        isRunning = false;
        CloseUtils.closeSocket(server);
    }
}
