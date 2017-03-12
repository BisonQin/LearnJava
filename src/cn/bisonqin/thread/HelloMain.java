package cn.bisonqin.thread;

/**
 * Created by Basil on 2017/2/26.
 */
public class HelloMain {

    public static void main(String[] args) throws InterruptedException {

        int idx = 1;

        for (int i = 0; i < 2; i++) {

            System.out.println("Main cn.bisonqin.thread running " + idx++);
            // Sleep 2101 miliseconds.
            Thread.sleep(2101);
        }

        HelloThread helloThread = new HelloThread();                //build a cn.bisonqin.thread object

        // Run cn.bisonqin.thread
        helloThread.start();

        for (int i = 0; i < 3; i++) {
            System.out.println("Main cn.bisonqin.thread running " + idx++);

            // Sleep 2101 miliseconds.
            Thread.sleep(2101);
        }

        System.out.println("==> Main cn.bisonqin.thread stopped");
    }
}