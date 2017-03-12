package cn.bisonqin.io.charIO;

import java.io.*;

/**
 * 字符流的操作
 * Created by Basil on 2016/3/13.
 */
public class CopyFileDemo {

    public static void main(String[] args) {
        //创建源仅限字符的纯文本
        File src = new File("e:/test/Demo03.java");
        File dest = new File("e:/test/newDemo03.java");
        //选择流
        Reader reader = null;
        Writer wr = null;
        try {
            reader = new FileReader(src);
            wr = new FileWriter(dest);
            //读取操作
            char[] flush = new char[1024];
            int len;
            while(-1 != (len=reader.read(flush))){
                wr.write(flush,0,len);
            }
            wr.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件读取错误");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写出错误");
        }finally{
            if(null != wr){
                try {
                    wr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != reader){         //先打开的后关闭
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
