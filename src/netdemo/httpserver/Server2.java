package netdemo.httpserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器并启动，版本1.1
 * （能看到get和post请求方式的请求信息）
 * Created by Basil on 2017/3/9.
 */
public class Server2 {

    private ServerSocket server;

    public static void main(String[] args) {
        Server2 server = new Server2();
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
            System.out.println(requireInfo);

//            BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();       //以字节数组缓冲流的形式存储资料
//
//            byte[] flush = new byte[1024];
//            int len = 0;
//            while(-1 != (len = bis.read(flush))) {                //这种方式会在此阻塞         //TODO handle the bug
//                bos.write(flush, 0, len);           //写入流中
//                System.out.println(new String(flush));
//            }
//            System.out.println("读取完毕");
//            bos.close();
//            bis.close();
//
//            System.out.println("请求的信息是：" + bos.toString().trim());

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
