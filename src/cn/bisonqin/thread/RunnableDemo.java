package cn.bisonqin.thread;

/**
 * Created by Basil on 2017/2/26.
 */
public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        int idx = 1;
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from RunnableDemo " + idx++);

            // Sleep 2 second.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }

}