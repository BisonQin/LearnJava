package netdemo.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器并启动，版本1.2
 * 1、请求
 * 2、响应
 * 3、封装响应
 * Created by Basil on 2017/3/9.
 */
public class Server4 {

    private ServerSocket server;
    private static final String CRLF = "\r\n";      //换行符
    private static final String BLANK = " ";        //空格

    public static void main(String[] args) {
        Server4 server = new Server4();
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
            byte[] data = new byte[20480];
            int len = client.getInputStream().read(data);               //直接读取指定长度(这种方式不是很好)

            //接收客户端的 请求信息
//            String requireInfo = new String(data, 0, len).trim();       //取出字符串并去除空格
//            System.out.println(requireInfo);

            //响应
            Response response = new Response(client.getOutputStream());
            response.println("<html><head><title>HTTP响应示例</title></head><body>Hello World！</body></html>");
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
