package cn.bisonqin.net.chatupdate;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Basil on 2017/3/9.
 */
public class CloseUtils {

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
}
