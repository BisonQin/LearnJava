package threaddemo;

/**
 * Created by Basil on 2017/2/26.
 */
public class RunnableTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main thread running..");

        // Create a thread from Runnable.
        Thread thread = new Thread(new RunnableDemo());

        thread.start();

        // Sleep 5 seconds.
        Thread.sleep(5000);
        System.out.println("Main thread stopped");
    }
}