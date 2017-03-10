package iodemo.file;

import java.io.File;
import java.io.FileFilter;

/**
 * 操作目录
 * mkdir();//创建目录，必须确保父目录存在
 * mkdirs();//创建目录，父目录乐意不存在，如果父目录不存在，一同创建
 * Created by Basil on 2016/3/12.
 */
public class Demo04 {

    public static void main(String[] args) {
        String path = "E:/test";
        File src = new File(path);
        if(src.isDirectory()){
            System.out.println("子目录||字文件名");
            String[] subName = src.list();

            for(String temp:subName){
                System.out.println(temp);
            }
            System.out.println("子目录||字文件对象");
            File[] subFiles = src.listFiles();
            for(File temp:subFiles){
                System.out.println(temp.getAbsolutePath());
            }
            System.out.println("子文件.java对象");
            //命令设计模式
            subFiles = src.listFiles(new FileFilter() {
                @Override
                /**
                 * dir代表src
                 */
                public boolean accept(File pathname) {
                    return false;
                }
            });
            for(File temp:subFiles){
                System.out.println(temp.getAbsolutePath());
            }
        }
    }

    public static void test01() {
        String path = "E:/test/test";
        File src = new File(path);
        src.mkdir();
    }
}
