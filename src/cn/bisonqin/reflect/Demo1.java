package cn.bisonqin.reflect;

/**
 * 获取结构信息class对象（源头）
 * Created by Basil on 2017/3/12.
 */
public class Demo1 {

    public static void main(String[] args) throws ClassNotFoundException {
        String str = "abc";
        //class对象
        //对象.getClass()
        Class<?> cla = str.getClass();
        //类.class
        cla = String.class;
        //完整路径
        cla = Class.forName("java.lang.String");
    }
}
