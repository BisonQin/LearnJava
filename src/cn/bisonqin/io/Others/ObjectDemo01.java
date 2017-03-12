package cn.bisonqin.io.Others;

import java.io.*;

/**
 * 引用类型
 * 不是所有的对象都可以序列化  java.io.NotSerializableException
 * 不是所有的属性都需要序列化  transient
 * Created by Basil on 2016/3/14.
 */
public class ObjectDemo01 {

    public static void main(String[] args) {
        try {
            read("e:/test/seri.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化
     */
    public static void read(String destPath) throws IOException, ClassNotFoundException {
        //创建源
        File src = new File(destPath);
        //选择流
        ObjectInputStream dis = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(src)
                )
        );
        //操作读取的顺序须与写出一致  必须存在才能读取
        //顺序不一致时，可能存在读取问题
        Object obj = dis.readObject();
        if(obj instanceof Employee){
            Employee emp = (Employee)obj;
            System.out.println(emp.getName());
            System.out.println(emp.getSalary());
        }
        dis.close();
    }

    /**
     * 序列化
     * @param destPath
     * @throws IOException
     */
    public static void seri(String destPath) throws IOException {
        Employee emp = new Employee("basil",5000);
        double point = 2.5;
        long num = 100L;
        String str = "数据类型";

        //创建源
        File dest = new File(destPath);
        //选择流
        ObjectOutputStream dos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dest)
                )
        );
        //操作
        dos.writeObject(emp);

        dos.flush();
        dos.close();
    }
}
