package cn.bisonqin.thread;

/**
 * Thread.join()是一个方法通知父线程等待在继续运行之前要完成这个线程。
 * Created by Basil on 2017/2/26.
 */
public class JoinThread extends Thread {
    private String threadName;
    private int count;

    public JoinThread(String threadName, int count) {
        this.threadName = threadName;
        this.count = count;
    }

    @Override
    public void run() {

        for (int i = 1; i < count + 1; i++) {
            System.out.println("Hello from " + this.threadName + " " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("\n==> Thread " + threadName + " end!\n");
    }
}