package threaddemo;

/**
 * 守护线程
 * Java一个重要守护线程是垃圾收集线程。这意味着收集资源中不再使用解放出来的内存。当所有用户线程停止运行，垃圾收集线程也会停止。
 * Created by Basil on 2017/2/26.
 */
public class DeamonThread extends Thread{

    @Override
    public void run() {
        int count = 0;

        // Infinite loop
        while (true) {
            System.out.println("+ Hello from Deamon Thread " + count++);
            try {
                // Sleep 2 second
                sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}
