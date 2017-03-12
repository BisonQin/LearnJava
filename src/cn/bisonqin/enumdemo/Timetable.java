package cn.bisonqin.enumdemo;

/**
 * 时间表，每一天干什么事
 * Created by Basil on 2017/2/25.
 */
public class Timetable {

    // 返回这个人在某一天应该干的事
    //没有类型安全：首先，它不是类型安全的;您可以指定任何有效的int值到dayInWeek
    //任何有意义的打印：任何这些常数的值被打印，而不是打印一个有意义的名称，其数值就是当您打印MONDAY会打印出“2”，而不是“MONDAY”
    public static String getJob(int dayInWeek) {
        if (dayInWeek == WeekDayConstants.SATURDAY
                || dayInWeek == WeekDayConstants.SUNDAY) {
            return "Nothing";
        }
        return "Coding";
    }

    //类型安全，只有WeekDay类型的参数才能传进去
    //只需要知道是星期几就行，没必要需要个1,2,3
    public static String getJob(WeekDay weekDay) {
        if (weekDay == WeekDay.SATURDAY || weekDay == WeekDay.SUNDAY) {
            return "Nothing";
        }
        return "Coding";
    }

}