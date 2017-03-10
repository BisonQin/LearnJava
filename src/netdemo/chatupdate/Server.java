package netdemo.chatupdate;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器,接收数据
 * 写出数据  输出流
 * 写入数据  输入流
 *
 * 缺点：只能为一个客户端服务，有先后顺序
 * Created by Basil on 2017/3/9.
 */
public class Server {

    private static List<MyChannel> threadList = new ArrayList<>();     //客户端连接线程的集合

    public static void main(String[] args) throws IOException {
        new Server().start();
    }

    /**
     * 检查用户名是否已经存在
     * @param name
     * @return
     */
    public static boolean isNameExist(String name) {
        if(null == name || name.equals("")) {       //名字为空，视为存在，要用户重新输入
            System.out.println("名字不合法");
            return true;
        }
        if(threadList.isEmpty()) {
            System.out.println("容器是空的");
        }
        for(MyChannel other : threadList) {
            System.out.println("正在检验有效性");
            if(other.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true) {
            Socket client = server.accept();                //阻塞

            MyChannel channel = new MyChannel(client);      //单独创建一条线程负责和该客户端进行通讯
            threadList.add(channel);
            new Thread(channel).start();                    //一条道路
            System.out.println("创建成功");
            System.out.println("容器是否为空" + threadList.isEmpty());
        }
    }

    /**
     * 一个客户端一条道路
     * 1、输入流
     * 2、输出流
     * 3、接收数据
     * 4、发送数据
     */
    private class MyChannel implements Runnable {

        private DataInputStream dis;            //输入流（客户端 --》 服务器）
        private DataOutputStream dos;           //输出流（服务器 --》 客户端）
        private boolean isRunning = true;       //线程存活标识
        private String name;                    //该线程名字与客户端的名字一样

        public MyChannel(Socket client) {
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());

                this.name = dis.readUTF();
                this.send( this.name + "您好，欢迎进入聊天室");       //往客户端发送
                sendOthers(this.name + "进入了聊天室", true);         //向其他客户端线程发送系统信息
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                CloseUtils.closeAll(dis, dos);
            }
        }

        /**
         * 读取数据
         * @return
         */
        private String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
                System.out.println("服务器接收了来自" + this.name + "信息--->" + msg);
            } catch (IOException e) {
                //e.printStackTrace();
                sendOthers(this.name + "已离开", true);
                isRunning = false;
                CloseUtils.closeAll(dis);
                threadList.remove(this);        //出现异常，把本线程移除
            }
            return msg;
        }

        /**
         * 发送数据
         * @param msg
         */
        private void send(String msg) {
            if(null == msg || msg.equals("")) {
                return ;
            }
            try {
                dos.writeUTF(msg);
                System.out.println("服务器发送了-->" + msg);
                dos.flush();
            } catch (IOException e) {
                //e.printStackTrace();
                sendOthers(this.name + "已离开聊天室", true);
                isRunning = false;
                CloseUtils.closeAll(dos);
                threadList.remove(this);
            }
        }

        /**
         * 发送给其他客户端
         */
        private void sendOthers(String msg, boolean sys) {
            if(msg.equals("") || null == msg) {             //不允许发送空消息
                return;
            }
            //是否是私聊
            if(msg.startsWith("@") && msg.indexOf(":") > -1) {               //私聊
                //获取名字
                String name = msg.substring(1, msg.indexOf(":"));
                //获取内容
                String content = msg.substring(msg.indexOf(":") + 1);
                for(MyChannel other : threadList) {
                    if(other.name.equals(name)) {
                        other.send(this.name + "对您悄悄的说：" + content);
                    }
                }
            }else {
                //遍历容器
                for(MyChannel other : threadList) {
                    if(this == other) {
                        continue;       //跳过自身
                    }

                    //发送其他客户端
                    if(sys) {           //系统信息
                        other.send("系统信息：" + msg);
                    }else {
                        other.send(this.name + "对所有人说：" + msg);
                    }
                }
            }


        }

        @Override
        public void run() {
            while(isRunning) {
                sendOthers(receive(),false);
            }
        }
    }
}
