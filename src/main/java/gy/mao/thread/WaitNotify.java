package gy.mao.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotify {
    static class TestWait{
    }

    static char[] str = new char[]{'a','b','c','d','e'};
    static int[] num = new int[]{1, 2, 3, 4, 5, 6};
//    static volatile int num = 0;
    public static void main(String[] args) throws InterruptedException{
        Lock lock = new ReentrantLock();
        TestWait testWait = new TestWait();
        new Thread(()->{
            synchronized (testWait){
                lock.lock();
                for (int i = 0; i < str.length; i++) {
                    try {
                        System.out.print(str[i]);
                        testWait.notifyAll();
                        testWait.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(()->{
            synchronized (testWait){
                for (int i = 0; i < num.length; i++) {
                    try {
                        System.out.print(num[i]);
                        testWait.notifyAll();
                        testWait.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
//        synchronized (testWait){
//            testWait.notifyAll();
//        }

    }
}
