package iodemo.file;


import java.io.File;

/**
 * 相对路径与绝对路径构造File对象
 * Created by Basil on 2016/3/12.
 */
public class Demo02 {

    public static void main(String[] args) {
        String parentPath = "E:/test";
        String name = "image.jpg";

        //相对路径
        File src = new File(parentPath,name);
        src = new File(new File(parentPath),name);

        //输出
        System.out.println(src.getName());
        System.out.println(src.getPath());

        //绝对路径
        src = new File("E:/test/image.jpg");
        System.out.println(src.getName());
        System.out.println(src.getPath());

        //没有盘符:以user:dir构建
        src = new File("test.txt");
        System.out.println(src.getName());
        System.out.println(src.getPath());
        System.out.println(src.getAbsolutePath());
    }
}
