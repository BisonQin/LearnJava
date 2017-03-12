package cn.bisonqin.io.Others;

import java.io.*;

/**
 * 数据，类型输出到字节数组中
 * Created by Basil on 2016/3/14.
 */
public class DataDemo02 {

    public static void main(String[] args) {
        try {
            byte[] data = write();
            System.out.println(data.length);
            read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从字节数组中读取数据加类型
     */
    public static void read(byte[] src) throws IOException {
        //选择流
        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new ByteArrayInputStream(src)
                )
        );
        //操作读取的顺序须与写出一致  必须存在才能读取
        //顺序不一致时，可能存在读取问题
        double num1 = dis.readDouble();
        long num2 = dis.readLong();
        String str = dis.readUTF();
        dis.close();
        System.out.println(num2+"-->"+str);
    }

    /**
     * 数据+类型输出到字符数组
     * @throws IOException
     */
    public static byte[] write() throws IOException {
        //目标数组
        byte[] dest = null;
        double point = 2.5;
        long num = 100L;
        String str = "数据类型";

        //选择流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        bos
                )
        );
        //操作

        dos.writeDouble(point);
        dos.writeLong(num);
        dos.writeUTF(str);
        dos.flush();
        dest = bos.toByteArray();


        dos.close();

        return dest;
    }
}
