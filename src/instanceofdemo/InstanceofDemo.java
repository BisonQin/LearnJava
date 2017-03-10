package instanceofdemo;

/**
 * instanceof关键字的使用
 *
 * 抽象类是不能实例化的，以下展示的实例化
 * 其实是抽象类的一个匿名内部类的实例化
 *
 * Created by Basil on 2017/2/25.
 */
public class InstanceofDemo {

    public static void test() {
        System.out.println("测试匿名内部类");
    }

    public static void main(String[] args) {

        // 创建一个Animal对象
        // 但是Animal类是一个抽象类
        // 抽象类不可以用new创建对象。因为调用抽象方法没意义
        Animal tom = new Cat("Tom", 3, 20);

        System.out.println("name: " + tom.getName());               //name: Tom
        System.out.println("animalName: " + tom.getAnimalName());   //animalName: instanceofdemo.Cat

        //但是这样是否与抽象类不能实例化相违背呢？其实不是，这里创建的aninal实际上是Animal的一个子类
        //这种写法是匿名内部类
        Animal animal = new Animal("bbb") {
            @Override
            public String getAnimalName() {
                return "aaa";
            }
        };
        System.out.println(animal.getName());           //bbb


        // 用instanceof判断对象是否是特定类的一个实例
        boolean isMouse = tom instanceof Mouse;
        System.out.println("Tom is mouse? " + isMouse);         //Tom is mouse? false

        boolean isCat = tom instanceof Cat;
        System.out.println("Tom is cat? " + isCat);             //Tom is cat? true

        boolean isAnimal = tom instanceof Animal;
        System.out.println("Tom is animal? " + isAnimal);      //Tom is animal? true
    }

}