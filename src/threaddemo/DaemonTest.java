package threaddemo;

/**
 *
 * Created by Basil on 2017/2/26.
 */
public class DaemonTest {

    public static void main(String[] args) {
        System.out.println("==> Main Thread running..\n");

        // Create thread
        Thread deamonThread = new DeamonThread();

        // Set deamon true
        // marks this thread as a daemon thread
        deamonThread.setDaemon(true);
        deamonThread.start();

        // Create other thread
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