package cn.bisonqin.io.file;

import java.io.File;

/**
 * 两个常用的常量
 * 1.路径分隔符
 * 2.文件分隔符(Windows \)(Linux等 /)
 * Created by Basil on 2016/3/12.
 */
public class Demo01 {

    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);

        //路径的几种表现形式
        String path ="E:\\Picture\\image.jpg";
        System.out.println(path);
        path="E:"+File.separator+"Picture"+File.separator+"image.jpg";
        System.out.println(path);
        //推荐的方式
        path = "E:/Picture/image.jpg";
        System.out.println(path);
    }
}
