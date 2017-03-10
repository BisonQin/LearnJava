package StringDemo;

/**
 * StringBuilder和StringBuffer的方法类似
 * Created by Basil on 2017/2/26.
 */
public class StringBuilderDemo {

    public static void main(String[] args) {

        // 创建一个StringBuilder对象
        // 只是创建对象，并没有任何字符
        StringBuilder sb = new StringBuilder(10);

        // 拼接Hello...字符串
        sb.append("Hello...");
        System.out.println("- sb after appends a string: " + sb);

        // 拼接一个符号
        char c = '!';
        sb.append(c);
        System.out.println("- sb after appending a char: " + sb);

        // 插入一个字符串到指定下标之后
        sb.insert(8, " Java");
        System.out.println("- sb after insert string: " + sb);

        // 删除指定下标之间的字符
        sb.delete(5,8);

        System.out.println("- sb after delete: " + sb);
    }
}