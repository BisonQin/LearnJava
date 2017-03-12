package cn.bisonqin.inherit;

import cn.bisonqin.instanceofdemo.Cat;

/**
 * 继承的示例代码
 *
 * 1、子类能继承到父类的方法以及成员变量
 * 2、子类也能使用子类特有的方法
 *
 * Created by Basil on 2017/2/25.
 */
public class InheritMethodDemo {

    public static void main(String[] args) {

        // 创建一个Cat对象
        Cat tom = new Cat("Tom", 3, 20);

        // 使用子类继承到父类的方法
        System.out.println("name: "+ tom.getName());
        System.out.println("animalName: "+ tom.getAnimalName());

        System.out.println("-----------------");

        // 使用子类特有的方法
        System.out.println("Age: "+ tom.getAge());
        System.out.println("Height: "+ tom.getHeight());
    }

}