package iodemo.pattern;

/**
 * Created by Basil on 2016/3/14.
 */
public class App {

    public static void main(String[] args) {
        Voice v = new Voice();
        v.say();
        Amplifier am = new Amplifier(v);
        am.say();
    }
}
