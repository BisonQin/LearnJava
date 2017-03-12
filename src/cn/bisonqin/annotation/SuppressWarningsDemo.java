package cn.bisonqin.annotation;

import java.util.Date;

/**
 * Created by Basil on 2017/2/25.
 */
public class SuppressWarningsDemo {

    @SuppressWarnings("deprecation")        //使用注解，使编译器去除警告
    public Date getSomeDate() {

        Date date = new Date(2014, 9, 25);  //这里去除了已经废弃的构造器的警告
        return date;
    }

}