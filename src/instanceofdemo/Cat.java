package instanceofdemo;

/**
 * Created by Basil on 2017/2/25.
 */
public class Cat extends Animal {

    private int age;        //年龄
    private int height;     //身高

    public Cat(int age, int height) {
        //几时不写super();在编译时也会增加此句
        super();

        // 初始化Cat的值
        this.age = age;
        this.height = height;
    }

    public Cat(String name, int age, int height) {

        //一旦调用了super的语句，super()就不会被调用了;
        super(name);

        // 初始化Cat的值
        this.age = age;
        this.height = height;
    }

    //Get和Set方法
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    // 继承父类的抽象方法，并设置父类的name变量的值为"instanceofdemo.Cat"
    @Override
    public String getAnimalName() {
        return "instanceofdemo.Cat";
    }

}
