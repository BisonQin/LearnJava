package iodemo.file;

import java.io.File;
import java.io.IOException;

/**
 * 常用的方法
 * Created by Basil on 2016/3/12.
 */
public class Demo03 {

    public static void main(String[] args) {
        test03();
    }

    public static void test03(){
        String path = "E:/test/200.jpg";
        File src = new File(path);
        if(!src.exists()){
            boolean flag = false;
            try {
                flag = src.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(flag?"成功":"失败");
        }
        //删除文件
        boolean flag = src.delete();
        System.out.println(flag?"成功":"失败");

        try {
            File temp = File.createTempFile("tes","temp",new File("E:/test"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void test02(){
        //String path = "image.txt";
        String path = "E:/test/image.jpg";
        File src = new File(path);
        System.out.println("文件是否存在："+src.exists());
        //是否可读写
        System.out.println("文件是否可读写："+src.canWrite());
        System.out.println("======================");
        if(src.isFile()){
            System.out.println("文件");
        }else if(src.isDirectory()){
            //没有真实存在的，默认为文件夹
            System.out.println("文件夹");
        }else{
            System.out.println("文件不存在");
        }
        System.out.println("长度为"+src.length());//只有文件才能读出长度
    }

    public static void test01(){
        //建立联系
        File src = new File("E:/test/image.jpg");
        System.out.println(src.getName());//返回名称
        System.out.println(src.getPath());//如果是绝对路径，返回完整路径，否则返回绝对路径
        System.out.println(src.getAbsolutePath());//返回完整路径
        System.out.println(src.getParent());//返回上一级目录，如果是相对路径，则返回null
    }
}
