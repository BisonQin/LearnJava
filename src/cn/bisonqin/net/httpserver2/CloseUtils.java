package cn.bisonqin.net.httpserver2;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Basil on 2017/3/9.
 */
public class CloseUtils {

    /**
     * 关闭全部流
     * @param io
     */
    public static void closeAll(Closeable... io) {
        for(Closeable temp : io) {
            if(null != temp) {
                try {
                    temp.close();
                } catch (IOException e) {
                    //TODO handle error
                }
            }
        }
    }

    /**
     * 使用泛型方法实现关闭IO流
     * @param io
     * @param <T>
     */
    public static <T extends Closeable> void close(T... io) {
        for(Closeable temp : io) {
            if(null != temp) {
                try {
                    temp.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                }
            }
        }
    }

    /**
     * 关闭Socket
     * @param socket
     */
    public static void closeSocket(ServerSocket socket) {
        if(null != socket) {
            try {
                socket.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }

    /**
     * 关闭Socket
     * @param socket
     */
    public static void closeSocket(Socket socket) {
        if(null != socket) {
            try {
                socket.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }
}
