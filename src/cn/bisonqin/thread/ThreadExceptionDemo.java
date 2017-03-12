package cn.bisonqin.thread;

import java.util.Random;

/**
 * Created by Basil on 2017/2/26.
 */
public class ThreadExceptionDemo {

    public static class RunnableTest implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread running ..");

            while (true) {
                Random r = new Random();

                // A random number from 0-99
                int i = r.nextInt(100);
                System.out.println("Next value " + i);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }

                if (i > 70) {
                    // Simulate an exception was not handled in the cn.bisonqin.thread.
                    throw new RuntimeException("Have a problem...");
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("==> Main cn.bisonqin.thread running...");

        Thread thread = new Thread(new RunnableTest());
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("#Thread: " + t);
                System.out.println("#Thread exception message: " + e.getMessage());
            }
        });

        thread.start();
        System.out.println("==> Main cn.bisonqin.thread end...");
    }

}