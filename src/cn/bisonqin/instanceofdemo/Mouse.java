package cn.bisonqin.instanceofdemo;

/**
 * Created by Basil on 2017/2/25.
 */
public class Mouse extends Animal {

    private int weight;     //体重

    // 默认的构造器
    public Mouse() {
        // 调用另一个构造器并传入100的值
        this(100);
    }


    // 有一个参数的构造器
    public Mouse(int weight) {

        // 如果你不写super();
        // Java也会调用父类的默认构造器，即super();

        this.weight = weight;
    }


    // 两个参数的构造器
    public Mouse(String name, int weight) {
        //指定调用父类带有一个参数的构造器
        super(name);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String getAnimalName() {
        return "cn.bisonqin.instanceofdemo.Mouse";         //指定父类的name值为"cn.bisonqin.instanceofdemo.Mouse"
    }
}