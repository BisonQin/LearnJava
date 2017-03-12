package cn.bisonqin.thread;

/**
 * Created by Basil on 2017/2/26.
 */
public class NoneDeamonThread extends Thread {

    @Override
    public void run() {
        int i = 0;

        // Loop 10 times. This cn.bisonqin.thread will end.
        while (i < 10) {
            System.out.println("  - Hello from None Deamon Thread " + i++);
            try {

                // Sleep 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        // None deamon cn.bisonqin.thread ending.
        System.out.println("\n==> None Deamon Thread ending\n");
    }
}