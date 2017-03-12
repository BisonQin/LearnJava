package cn.bisonqin.io.byteIO;

import java.io.*;

/**
 * 写出文件
 * Created by Basil on 2016/3/13.
 */
public class Demo02 {

    public static void main(String[] args) {
       // 1.建立联系，目的地
        File dest = new File("e:/test/test.txt");
        //2.选择流，文件输出流
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest,true);//true代表以追加的方式写出文件
            //操作
            String str = "Hello,World\n";
            //字符串转字节数组
            byte[] data = str.getBytes();
            os.write(data,0,data.length);

            os.flush();//强制刷新出去
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件没找到");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写出失败");
        }finally{
            //释放资源
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关闭输出流失败");
            }
        }
    }
}
