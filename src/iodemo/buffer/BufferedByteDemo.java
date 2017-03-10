package iodemo.buffer;

import java.io.*;

/**
 *字节流文件拷贝加入缓冲流，提高性能
 * （节点流）
 * Created by Basil on 2016/3/14.
 */
public class BufferedByteDemo {

    public static void main(String[] args) {

    }

    public static void copyFile(File src, File dest) throws IOException {
        if(!src.isFile()){//不是文件或者为null
            System.out.println("复制文件函数只能拷贝文件，不能复制目录");
            return;
        }
        //如果dest为已经存在的文件夹，不能建立于文件夹同名的文件
        if(dest.isDirectory()){
            System.out.println("不能建立与文件夹同名的文件");
            throw new IOException(dest.getAbsolutePath()+"不能建立与文件夹同名的文件");
        }

        //2.选择流
        InputStream is = null;
        OutputStream os = null;
        is = new BufferedInputStream(new FileInputStream(src)); //提高性能
        os = new BufferedOutputStream(new FileOutputStream(dest));

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
    }
}
