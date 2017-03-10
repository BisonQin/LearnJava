package netdemo.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 接收线程
 * Created by Basil on 2017/3/9.
 */
public class Receive implements Runnable{

    private DataInputStream dis;            //输入流
    private boolean isRunning = true;       //线程标识

    public Receive() {

    }

    public Receive(Socket client) {
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            CloseUtils.closeAll(dis);
        }
    }

    /**
     * 接收数据的方法
     * @return
     */
    public String receive() {
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            CloseUtils.closeAll(dis);
        }
        return msg;
    }

    @Override
    public void run() {
        //线程主体
        while(isRunning) {
            System.out.println("接收到的数据是" + receive());
        }
    }
}
