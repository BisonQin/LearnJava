package cn.bisonqin.io.byteIO;

import java.io.*;

/**
 * 文件的拷贝
 * Created by Basil on 2016/3/13.
 */
public class CopyFile {

    public static void main(String[] args) {
        copyFile("e:/test/image.jpg","e:/test/test/new.jpg");
    }

    public static void copyFile(String srcPath,String destPath){
        //1.建立联系
        File src = new File(srcPath);//源文件必须存在
        File dest = new File(destPath);//目的地的文件可以不存在
        if(!src.isFile()){
            System.out.println("只能拷贝文件");
            return;
        }
        //2.选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);

            //3.文件的拷贝
            byte[] flush = new byte[1024];
            int len = 0;
            while(-1 != (len = is.read(flush))){
                //写出
                os.write(flush,0,len);
            }
            os.flush();//强制输出

            //关闭两个流
            os.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件读取失败");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写出失败");
        }
    }
}
