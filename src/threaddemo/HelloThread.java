package threaddemo;

/**
 * Created by Basil on 2017/2/26.
 */
public class HelloThread extends Thread {


    // Code of method run() will be executed when
    // thread call start()
    @Override
    public void run() {
        int index = 1;

        for (int i = 0; i < 10; i++) {
            System.out.println("  - HelloThread running " + index++);

            try {
                // Sleep 1030 miliseconds.
                Thread.sleep(1030);
            } catch (InterruptedException e) {
            }

        }
        System.out.println("  - ==> HelloThread stopped");
    }
}