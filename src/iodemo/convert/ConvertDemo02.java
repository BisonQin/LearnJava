package iodemo.convert;

import java.io.*;

/**
 * 转换流：字节转为字符
 * 1.输出流OutputStream    编码
 * 2.输入流                解码
 * Created by Basil on 2016/3/14.
 */
public class ConvertDemo02 {

    public static void main(String[] args) throws IOException {
        //指定解码字符集
        BufferedReader br = new BufferedReader(
                new InputStreamReader(      //转换
                new FileInputStream(new File("e:/test/Demo03.java")),"UTF-8")
        );
        //写出文件
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(        //处理流处理
                new FileOutputStream(new File("e:/test/BufferedDemo03.java")),"gbk")
        );
        String info = null;
        while(null != (info = br.readLine())){
            System.out.println(info);
        }
        br.close();
    }
}
