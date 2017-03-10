package iodemo.file;

import java.io.File;
import java.util.Arrays;

/**
 * 输出子孙级目录|文件名称
 * Created by Basil on 2016/3/12.
 */
public class Demo05 {

    public static void main(String[] args) {
  //      String path = "E:/test";
   //     File parent = new File(path);
     //   printName(parent);

        File[] roots = File.listRoots();
        System.out.println(Arrays.toString(roots));
    }

    /**
     * 输出路径
     */
    public static void printName(File src){
        if(null == src || !src.exists()){
            return;
        }
        System.out.println(src.getAbsolutePath());
        if(src.isDirectory()){
            for(File sub:src.listFiles()){
                printName(sub);
            }
        }
    }
}
