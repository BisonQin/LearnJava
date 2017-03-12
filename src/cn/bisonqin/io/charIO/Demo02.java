package cn.bisonqin.io.charIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 文件的写出
 * Created by Basil on 2016/3/13.
 */
public class Demo02 {

    public static void main(String[] args) {
        //创建源
        File dest = new File("e:/test/test.txt");
        //选择流
        Writer wr = null;
        try {
            wr = new FileWriter(dest);
            //写出
            String msg = "锄禾日当午\r\n码农真辛苦\r\n一本小破书\r\n读了一上午\r\n";
            wr.write(msg);
            wr.append("\r\n测试拼接");

            wr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(null != wr){
                try {
                    wr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
