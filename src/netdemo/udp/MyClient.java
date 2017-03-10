package netdemo.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 客户端
 * 1、创建客户端 + 端口
 * 2、准备数据
 * 3、打包(发送的地点 + 端口)
 * 4、发送
 * 5、释放
 *
 * 思考：89.123    数据+类型（发送的时候由类型转成字节数组，服务器接收时转为相应的数据类型就可以了）
 * Created by Basil on 2017/3/8.
 */
public class MyClient {

    public static void main(String[] args) throws IOException {
        //1、创建客户端 + 端口
        DatagramSocket client = new DatagramSocket(6666);           //指定客户端的端口
        //2、准备数据
        String msg = "UDP编程";
        byte[] data = msg.getBytes();
        //3、打包
        DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost",8888));
        //4、发送
        client.send(packet);
        client.close();
    }

    /**
     * 字节数组  数据源 + Data 输出流
     * @param num
     * @return
     */
    public static byte[] convert(double num) throws IOException {
        byte[] data = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeDouble(num);
        dos.flush();

        //获取数据
        data = bos.toByteArray();
        dos.close();

        return data;
    }
}
