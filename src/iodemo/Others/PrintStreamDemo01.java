package iodemo.Others;

import java.io.*;

/**
 * PrintStream   打印流-->处理流
 * Created by Basil on 2016/3/14.
 */
public class PrintStreamDemo01 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("test");
        PrintStream ps = System.out;
        ps.println(false);

        //输出到文件
        File src = new File("e:/test/print.txt");
        ps = new PrintStream(
                new BufferedOutputStream(
                new FileOutputStream(src)
        ));
        ps.println("io is so easy....");

        ps.close();
    }
}
