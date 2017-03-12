package cn.bisonqin.net.chatupdate;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据，线程
 * Created by Basil on 2017/3/9.
 */
public class Send implements Runnable{

    private BufferedReader console;     //控制台输入流
    private DataOutputStream dos;       //管道输出流
    private boolean isRunning = true;   //线程状态标识
    private String name;

    public Send() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket client, String name) {
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
            this.name = name;
            send(name);
        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            CloseUtils.closeAll(dos, console);      //关闭所有的流
        }
    }

    //从控制台接收数据
    private String getMsgFormConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return null;
    }

    /**
     * 1、从控制台接收数据
     * 2、发送数据
     */
    public void send(String msg) {
        if(null != msg && !msg .equals("")) {
            try {
                dos.writeUTF(msg);
                dos.flush();            //强制刷新
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                CloseUtils.closeAll(dos, console);      //关闭所有的流
            }
        }
    }

    @Override
    public void run() {
        //线程体
        while(isRunning) {
            send(getMsgFormConsole());
        }
    }

}
