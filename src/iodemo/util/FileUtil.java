package iodemo.util;

import java.io.*;

/**
 * 文件的操作和拷贝
 * Created by Basil on 2016/3/13.
 */
public class FileUtil {

    /**
     * 文件的拷贝
     * @param srcPath
     * @param destPath
     */
    public static void copyFile(String srcPath,String destPath) throws IOException {
        //1.建立联系
        copyFile(new File(srcPath),new File(destPath));
    }

    /**
     * 文件的拷贝
     * @param src
     * @param dest
     */
    public static void copyFile(File src,File dest) throws IOException {
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

            is = new BufferedInputStream(new FileInputStream(src));
            os = new BufferedOutputStream(new FileOutputStream(dest));      //加入了缓冲流

            //3.文件的拷贝
            byte[] flush = new byte[1024];
            int len = 0;
            while (-1 != (len = is.read(flush))) {
                //写出
                os.write(flush, 0, len);
            }
            os.flush();//强制输出
            //关闭两个流
            os.close();
            is.close();
    }

    /**
     * 拷贝文件夹
     * @param src
     * @param dest
     */
    public static void copyDir(File src,File dest) throws IOException {
        if(src.isDirectory()){  //源文件夹存在的情况下
            dest = new File(dest,src.getName());//创建新的同名文件夹
        }
        copyDirDetail(src,dest);
    }

    public static void copyDir(String srcPath,String destPath) throws IOException {
        File src = new File(srcPath);
        File dest = new File(destPath);
        copyDir(src,dest);
    }

    /**
     * 拷贝文件夹细节
     * @param src
     * @param dest
     */
    public static void copyDirDetail(File src,File dest) throws IOException {
        if(src.isFile()){
            FileUtil.copyFile(src,dest);//文件的话直接复制
        }else if(src.isDirectory()){
            //确保源文件夹存在,不存在就创建
            dest.mkdirs();
            //获取下一级目录，文件
            for(File sub:src.listFiles()){
                copyDir(sub,new File(dest,sub.getName()));
            }
        }
    }

    /**
     * 工具类关闭流
     * 可变参数：...   只能形参放在最后一个位置,处理方式与数组一致
     */
    public static void close(String info,Closeable ... io){
        for(Closeable temp:io){
            if(null !=temp){
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用泛型
     */
    public static <T extends Closeable> void closeAll(T ... io){
        for(Closeable temp:io){
            if(null != temp){
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
