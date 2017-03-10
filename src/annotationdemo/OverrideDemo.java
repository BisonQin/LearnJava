package annotationdemo;

/**
 * Created by Basil on 2017/2/25.
 */
public class OverrideDemo {

    public static void main(String[] args) {

    }
}

class Man {

    private String name;

    public Man() {

    }

    public Man(String name) {
        this.name = name;
    }

    public Man(String name, int age) {

    }

    public String getName() {
        return "Man";
    }
}

class Chinese extends Man{

//    public Chinese(String name) {         //当父类没有无参构造器时（有一个有参构造器），子类继承父类时，要用super调用那个有参构造器
//        super(name);
//    }


    @Override
    public String getName() {
        return "Chinese";
    }
}
