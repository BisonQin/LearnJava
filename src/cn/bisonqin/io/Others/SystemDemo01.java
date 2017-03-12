package cn.bisonqin.io.Others;

import java.io.*;
import java.util.Scanner;

/**
 * 三个常量
 * 1.System.in      输入流 键盘输入
 * 2.System.out     输出流  控制台输出
 *   System.err
 *
 * -->重定向
 * setIn()
 * setOut()
 * setErr()
 * FileDescriptor.in
 * FileDescriptor.out
 * Created by Basil on 2016/3/14.
 */
public class SystemDemo01 {

    public static void main(String[] args) throws FileNotFoundException {
       // test();
        //重定向
        System.setOut(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("e:/test/out.txt")
                        )
                ,true )//true为是否flush
        );
        System.out.println("a");
        System.out.println("test");
        //回控制台
        System.setOut(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(FileDescriptor.out)
                )
                ,true )//true为是否flush
        );
        System.out.println("back....");
    }

    public static void test1() throws FileNotFoundException {
        InputStream is = System.in;     //键盘输入
        is = new BufferedInputStream(
                new FileInputStream(
                        "e:/test/print.txt"
                )
        );
        Scanner sc = new Scanner(is);
        // System.out.println("请输入：");
        System.out.println(sc.nextLine());
    }

    public static void test(){
        System.out.println("test");
        System.err.println("err");
    }
}
