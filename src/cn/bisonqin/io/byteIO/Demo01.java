package cn.bisonqin.io.byteIO;

import java.io.*;

/**
 * 文件的读取
 * Created by Basil on 2016/3/13.
 */
public class Demo01 {

    public static void main(String[] args) {
        //1.建立联系，File对象
        File src = new File("e:/test/file.txt");
        //2.选择流
        InputStream is = null;//提升作用域
        try {
            is = new FileInputStream(src);
            //3.操作不断读取缓存数组
            byte[] car = new byte[10];
            int len = 0;//接受实际读取的大小
            //循环读取
            while(-1 != (len = is.read(car))){
                //输出字节数组转成字符串
                String info = new String(car,0,len);
                System.out.println(info);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取文件失败");
        }finally{
            //4.释放资源
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    System.out.println("关闭文件输入流失败");
                }
            }
        }

    }
}
