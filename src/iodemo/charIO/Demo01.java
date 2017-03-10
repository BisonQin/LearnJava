package iodemo.charIO;

import java.io.*;

/**
 * 从文本读取
 * Created by Basil on 2016/3/13.
 */
public class Demo01 {

    public static void main(String[] args) {
        //创建源
        File src = new File("e:/test/test.txt");
        Reader reader = null;
        //选择流
        try {
            reader = new FileReader(src);
            //读取操作
            char[] flush = new char[1024];
            int len = 0;
            while(-1 != (len=reader.read(flush))){
                //字符数组转成字符串
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("源文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("源文件读取失败");
        }finally{
            if(null != reader){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
