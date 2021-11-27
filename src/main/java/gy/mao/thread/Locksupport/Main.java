package gy.mao.thread.Locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            LockSupport.unpark(Thread.currentThread()); // lockSupport相当于一个标识位，
            LockSupport.unpark(Thread.currentThread()); // lockSupport相当于一个标识位，
            System.out.println("thread-one start");
            LockSupport.park();
            System.out.println("thread-one go");
            LockSupport.park();
            System.out.println("thread-one over");
        });
        Thread two =  new Thread(() -> {
            System.out.println("thread-two start");
            LockSupport.park();
            System.out.println("thread-two over");
        });
        one.start();
        TimeUnit.SECONDS.sleep(5L);
        two.start();
        TimeUnit.SECONDS.sleep(2L);
        LockSupport.unpark(one);
        TimeUnit.SECONDS.sleep(5L);
        LockSupport.unpark(two);
    }
}
