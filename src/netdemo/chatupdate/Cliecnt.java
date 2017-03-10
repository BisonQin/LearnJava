package netdemo.chatupdate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 创建客户端，发送数据 + 接收数据
 * 写出数据  输出流
 * 读取数据  输入流
 *
 * 输入流与输出流在同一线程内，应该独立处理，彼此独立
 * Created by Basil on 2017/3/9.
 */
public class Cliecnt {

    public static void main(String[] args) throws IOException {
        String name = "";
        System.out.println("请输入用户名：");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("进来循环");
            name = br.readLine();
            boolean flag = Server.isNameExist(name);
            if(!flag) {
                break;
            }
        }

        if(name.equals("")) {           //设置用户名规则
            return;
        }

        Socket client = new Socket("localhost", 9999);          //此时和服务器建立连接

        //发送线程
        new Thread(new Send(client, name)).start();       //一条路径
        //接收线程
        new Thread(new Receive(client)).start();          //一条路径
    }
}
