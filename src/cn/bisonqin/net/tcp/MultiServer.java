package cn.bisonqin.net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 *
 * 1、创建服务端
 * 2、接收用户端的连接
 * 3、发送数据
 *
 * 接收多个客户端发送的信息
 * Created by Basil on 2017/3/8.
 */
public class MultiServer {

    public static void main(String[] args) throws IOException {
        //1、创建服务端
        ServerSocket serverSocket = new ServerSocket(8888);
        //2、 接收客户端的连接，阻塞式

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("客户端建立连接");

            //3、发送数据
            String msg = "TCP编程";
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(msg);
            dos.flush();
            dos.close();
        }
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//
//        bw.write(msg);
//        bw.newLine();
//        bw.close();


    }
}
