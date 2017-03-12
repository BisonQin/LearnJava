package cn.bisonqin.enumdemo;

/**
 * 枚举测试函数
 * Created by Basil on 2017/2/25.
 */
public class EnumDemo {

    public static void main(String[] args) {
        //1- Java枚举(Enum)是什么？ 枚举(enum)是Java的一个关键字，它用于表示在Java中公知的值的固定个数的特征，
        // 例如一周的天数，太阳系中的行星数量等。枚举(枚举)是在Java JDK 1.5中引入的，它的自动装箱和拆箱，泛型，
        // 可变参数和静态导入的J2SE 5最喜欢的功能之一。
        System.out.println(WeekDay.MONDAY);                 //枚举变量的名字
        System.out.println(WeekDay.MONDAY.ordinal());       //所表示的数字

        //2- 可以使用==操作符来比较枚举元素
        System.out.println("-------------------------------------------------");
        WeekDay weekDay = WeekDay.MONDAY;                   //给枚举变量赋值
        if(weekDay == WeekDay.MONDAY) {
            System.out.println("枚举可以用==比较相等");
        }

        //3- 枚举在Java中可以用来作为switch语句的参数
        System.out.println("-------------------------------------------------");
        switch (weekDay) {
            case MONDAY:
                System.out.println("Working day");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Holiday");
                break;
            default:
                System.out.println(weekDay);
        }

        //4- 获取所有枚举元素
        System.out.println("-------------------------------------------------");
        WeekDay[] allDays = WeekDay.values();

        for (WeekDay day : allDays) {
            System.out.println("Day: " + day);
        }
    }
}
