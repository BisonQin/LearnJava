package cn.bisonqin.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 服务端
 * 1、创建服务器端 + 端口
 * 2、准备接受容器
 * 3、封装成包
 * 4、接受数据
 * 5、分析数据
 * Created by Basil on 2017/3/8.
 */
public class MyServer {

    public static void main(String[] args) throws IOException {
        //创建服务器端 + 端口
        DatagramSocket server = new DatagramSocket(8888);           //可能端口被占用
        //2、准备接收容器
        byte[] container = new byte[1024];
        //3、封装成包
        DatagramPacket packet = new DatagramPacket(container, container.length);
        //4、接受数据
        server.receive(packet);
        //5、分析数据
        byte[] data = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(data, 0 , len));
        //6、释放资源
        server.close();

    }

    /**
     * 字节数组 + Data输入流
     * @param data
     * @return
     */
    public static double convert(byte[] data) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
       double num =  dis.readDouble();
        dis.close();
        return num;
    }
}
