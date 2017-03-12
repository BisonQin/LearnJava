package cn.bisonqin.thread;

/**
 * Created by Basil on 2017/2/26.
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n==> Main cn.bisonqin.thread starting..\n");

        Thread joinThreadA = new JoinThread("A*", 2);
        Thread joinThreadB = new JoinThread("B*", 3);


        // None join Thread.
        Thread noJoinThreadC = new JoinThread("C", 5);

        joinThreadA.start();
        joinThreadB.start();
        noJoinThreadC.start();

        // Using join()
        joinThreadA.join();
        joinThreadB.join();

        //Thread.join()是一个方法通知父线程等待在继续运行之前要完成这个线程。

        // The following code will have to wait until 2
        // JoinThread A, B completed.
        System.out.println("Hello from main cn.bisonqin.thread...");

        System.out.println("Thread A isLive? " + joinThreadA.isAlive());
        System.out.println("Thread B isLive? " + joinThreadB.isAlive());
        System.out.println("Thread C isLive? " + noJoinThreadC.isAlive());

        System.out.println("\n==> Main Thread end!\n");
    }
}