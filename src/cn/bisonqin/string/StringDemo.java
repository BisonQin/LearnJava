package cn.bisonqin.string;

/**
 * 测试String的各种方法
 * Created by Basil on 2017/2/26.
 */
public class StringDemo {

    public static void main(String[] args) {
        String str = "This is text";
        int len = str.length();                     //长度包括空格
        System.out.println("String Length is : " + len);

        Concat();                                   //拼接字符串
        System.out.println("===================================================");
        IndexOf(str);                               //查看自定字符的下标
        System.out.println("===================================================");
        SubString(str);                             //截取指定下标的字符串
        System.out.println("===================================================");
        ReplaceTest(str);                           //替换指定字符串
    }

    /**
     * 拼接字符串
     */
    public static void Concat() {
        String s1 = "This ";
        String s2 = "is ";
        String s3 = "text";

        String s = s1.concat(s2).concat(s3);                   //拼接三个字符串
        System.out.println("s1.concat(s2).concat(s3) = " + s);
    }

    /**
     * 搜索指定字符的下标
     * @param str
     */
    public static void IndexOf(String str) {
        //index这个函数计数是从0开始的，也就是下标从0开始
        // 从字符串的开头开始搜索i的下标
        int idx = str.indexOf('i');
        System.out.println("- indexOf('i') = " + idx);          //2

        // 从下标为4的字符开始搜索i下标
        idx = str.indexOf('i', 4);
        System.out.println("- indexOf('i',4) = " + idx);        //5

        // 搜索te开头的下标，实际上返回的结果是te前面这个t的下标
        idx = str.indexOf("te");
        System.out.println("- indexOf('te') = " + idx);         //8
    }

    /**
     * 截取指定下标的字符
     * @param str
     */
    public static void SubString(String str) {
        // 从下标为3开始一直到结尾截取
        String substr = str.substring(3);
        System.out.println("- substring(3)=" + substr);

        // 截取下标为2到7的字符串
        substr = str.substring(2, 7);
        System.out.println("- substring(2, 7) =" + substr);
    }

    /**
     * 替换指定字符或字符串
     * @param str
     */
    public static void ReplaceTest(String str) {
        // 把所有的i替换成x.
        String s2 = str.replace('i', 'x');
        System.out.println("- s2=" + s2);

        // 替换所有符合条件的is成abc (使用正则表达式)
        String s3 = str.replaceAll("is", "abc");
        System.out.println("- s3=" + s3);

        // 替换第一个符合条件的is成abc（正则表达式）
        String s4 = str.replaceFirst("is", "abc");
        System.out.println("- s4=" + s4);

        // 替换全部符合条件的字符或字符串（正则表达式）
        // "is|te": 表示"is" or "te" 替换成 "+".
        String s5 = str.replaceAll("is|te", "+");
        System.out.println("- s5=" + s5);
    }
}
