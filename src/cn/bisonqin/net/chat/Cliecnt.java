package cn.bisonqin.net.chat;

import java.io.*;
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
        Socket client = new Socket("localhost", 9999);

        //控制台输入流
        new Thread(new Send(client)).start();       //一条路径

        new Thread(new Receive(client)).start();          //一条路径
    }
}
