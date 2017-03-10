package netdemo.httpserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 创建服务器并启动，版本1.2
 * 1、请求
 * 2、响应
 * Created by Basil on 2017/3/9.
 */
public class Server3 {

    private ServerSocket server;
    private static final String CRLF = "\r\n";      //换行符
    private static final String BLANK = " ";        //空格

    public static void main(String[] args) {
        Server3 server = new Server3();
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
            String requireInfo = new String(data, 0, len).trim();       //取出字符串并去除空格
            //System.out.println(requireInfo);

            //响应
            StringBuilder responseContext = new StringBuilder();
            responseContext.append("<html><head><title>HTTP响应示例</title></head><body>Hello World</body></html>");

            StringBuilder response = new StringBuilder();
            //1、HTTP协议版本、状态代码、描述
            response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
            //2、响应头
            response.append("Server:Bison Server/1.0.0").append(CRLF);
            response.append("Date:").append(new Date()).append(CRLF);
            response.append("Content-type:text/html;charset=UTF-8").append(CRLF);
            //正文长度
            response.append("Content-length:").append(responseContext.toString().getBytes().length).append(CRLF);    //长度为字节长度
            //3、正文之前
            response.append(CRLF);
            //4、正文
            response.append(responseContext);

            //输出流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(response.toString());      //把响应信息写入流
            System.out.println(response.toString());
            bw.flush();                         //强制刷新
            bw.close();

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
