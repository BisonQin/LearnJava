package cn.bisonqin.io.Others;

import java.io.*;

/**
 * 数据类型处理流
 * 1.输入流DataInputStream
 * 2.输出流DataOutpuyStream
 *
 * java.io.EOFException：没有读取到相关的内容
 * Created by Basil on 2016/3/14.
 */
public class DataDemo01 {

    public static void main(String[] args) {
        try {
           // write("e:/test/data.txt");
            read("e:/test/data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件中读取数据加类型
     */
    public static void read(String destPath) throws IOException {
        //创建源
        File src = new File(destPath);
        //选择流
        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(src)
                )
        );
        //操作读取的顺序须与写出一致  必须存在才能读取
        //顺序不一致时，可能存在读取问题
        double num1 = dis.readDouble();
        long num2 = dis.readLong();
        String str = dis.readUTF();
        System.out.println(num2+"-->"+str);
    }

    /**
     * 数据+类型输出到文件
     * @param destPath
     * @throws IOException
     */
    public static void write(String destPath) throws IOException {
        double point = 2.5;
        long num = 100L;
        String str = "数据类型";

        //创建源
        File dest = new File(destPath);
        //选择流
        DataOutputStream dos = new DataOutputStream(
            new BufferedOutputStream(
                    new FileOutputStream(dest)
            )
        );
        //操作
        dos.writeDouble(point);
        dos.writeLong(num);
        dos.writeUTF(str);

        dos.flush();
        dos.close();
    }
}
