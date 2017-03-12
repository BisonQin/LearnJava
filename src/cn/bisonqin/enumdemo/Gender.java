package cn.bisonqin.enumdemo;

/**
 * 枚举中的构造方法和普通方法
 * Created by Basil on 2017/2/25.
 */
public enum Gender {


    // 初始化这个元素并调用构造器
    // 这个元素一直都是final, static的
    MALE("M", "Male"), FEMALE("F", "Female");

    private String code;
    private String text;

    // 这个构造器只能在枚举内部使用
    // 如果你不声明为private ，Java内部也会在前面添加为private
    private Gender(String code, String text) {          //可见这个private 在编辑器中显示是灰色的
        this.code = code;
        this.text = text;
    }


    // 一个通过code返回Gender元素的静态方法
    public static Gender getGenderByCode(String code) {
        for (Gender gender : Gender.values()) {
            if (gender.code.equals(code)) {
                return gender;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
