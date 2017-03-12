package cn.bisonqin.instanceofdemo;

/**
 * Created by Basil on 2017/2/25.
 */
public abstract class Animal {

    // Animal的名字，封装性，所以用private
    private String name;

    // 默认的构造器
    public Animal() {
        // 由子类决定name的默认值
        this.name = this.getAnimalName();
    }

    public Animal(String name) {
        this.name = name;
    }

    // Name的Get和Set函数
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 返回一个默认值给默认的呃构造器
    // 一个抽象方法
    // 此方法的会在子类中实现
    public abstract String getAnimalName();

}