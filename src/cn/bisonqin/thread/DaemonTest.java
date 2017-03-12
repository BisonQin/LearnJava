package cn.bisonqin.thread;

/**
 *
 * Created by Basil on 2017/2/26.
 */
public class DaemonTest {

    public static void main(String[] args) {
        System.out.println("==> Main Thread running..\n");

        // Create cn.bisonqin.thread
        Thread deamonThread = new DeamonThread();

        // Set deamon true
        // marks this cn.bisonqin.thread as a daemon cn.bisonqin.thread
        deamonThread.setDaemon(true);
        deamonThread.start();

        // Create other cn.bisonqin.thread
        new NoneDeamonThread().start();

        try {
            // Sleep 5 second
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        // Main Thread ending
        System.out.println("\n==> Main Thread ending\n");
    }

}