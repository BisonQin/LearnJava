package netdemo.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 客户端
 *（必须先启动服务器再连接）
 * 1、创建客户端，必须指定服务器+端口
 * 2、接收数据
 * Created by Basil on 2017/3/8.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        //1、创建客户端，必须指定度指定服务器+端口，此时就在连接
        Socket client = new Socket("localhost",8888);
        //2、接收数据
//        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//        String msg = br.readLine();
//        System.out.println(msg);
//        br.close();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);
        dis.close();
    }
}
