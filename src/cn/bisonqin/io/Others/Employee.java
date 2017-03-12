package cn.bisonqin.io.Others;

/**
 * 空接口，只是个标识
 * Created by Basil on 2016/3/14.
 */
public class Employee implements java.io.Serializable{
    private transient String name;//不需要序列化
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
