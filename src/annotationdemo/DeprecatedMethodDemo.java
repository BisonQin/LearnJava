package annotationdemo;

import java.util.Date;

/**
 * 测试Deprecated注解
 * Created by Basil on 2017/2/25.
 */
public class DeprecatedMethodDemo {

    /**
     * @deprecated replaced by {@link #todo(String,Date)}
     */
    @Deprecated
    public void todoJob(String jobName) {
        System.out.println("Todo " + jobName);
    }

    public void todo(String jobName, Date atTime) {
        System.out.println("Todo " + jobName + " at " + atTime);
    }

    public void todoNothing() {
        System.out.println("Todo Nothing");
    }

    public static void main(String[] args) {

        DeprecatedMethodDemo obj = new DeprecatedMethodDemo();

        obj.todoJob("Java coding");

        obj.todoNothing();
    }
}