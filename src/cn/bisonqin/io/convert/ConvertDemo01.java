package cn.bisonqin.io.convert;

import java.io.UnsupportedEncodingException;

/**
 *乱码的原因：
 * 1）编码与解码的字符集不统一
 * 2）字节数不完整
 * Created by Basil on 2016/3/14.
 */
public class ConvertDemo01 {

    public static void main(String[] args) {
        test02();
    }

    /**
     * 编码与解码的字符集必须相同，否则乱码
     * @throws UnsupportedEncodingException
     */
    public static void test01() throws UnsupportedEncodingException {
        //解码byte  -->char
        String str = "中国";
        //编码 char  -->byte
        byte[] data = str.getBytes();
        //编码与解码的字符集统一
        System.out.println(new String(data));
        data  = str.getBytes("gbk");//设定编码字符集
        //不统一出现乱码
        System.out.println(new String(data));
        //编码
        byte[] data2 = "中国".getBytes("gbk");
        //解码
        str = new String(data2,"gbk");  //如果不指定，就是用默认的
        System.out.println(str);
    }

    public static void test02(){
        String str = "中国";
        byte[] data = str.getBytes();
        //字节数不完整
        System.out.println(new String(data,0,4));
    }
}
