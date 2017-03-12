package cn.bisonqin.net.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器,接收数据
 * 写出数据  输出流
 * 写入数据  输入流
 *
 * 缺点：只能为一个客户端服务，有先后顺序
 * Created by Basil on 2017/3/9.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true) {                      //这样写会有客户端的先后顺序
            Socket client = server.accept();

            //写入数据（读取客户端传来的数据）
            DataInputStream dis = new DataInputStream(client.getInputStream());
            //写出数据（返还给客户端）
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            while(true) {
                String msg = dis.readUTF();
                dos.writeUTF("服务器收到 ----->" + msg);
                dos.flush();
            }
        }
    }
}
