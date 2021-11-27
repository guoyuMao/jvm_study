package gy.mao.Col;

import sun.awt.Mutex;

import javax.sound.midi.Soundbank;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(8);

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread one = new Thread(() -> {
            System.out.println("one");
            reentrantLock.lock();
            try {TimeUnit.SECONDS.sleep(10);} catch (InterruptedException e) {}
            System.out.println("one run");
            reentrantLock.unlock();
            System.out.println("one over");
        });
        Thread two = new Thread(() -> {
            System.out.println("two");
            reentrantLock.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("线程被打断");
            }
            System.out.println("two run");
            reentrantLock.unlock();
            System.out.println("two over");
        });
        Thread three = new Thread(() -> {
            System.out.println("three");
            reentrantLock.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("线程被打断");
            }
            System.out.println("three run");
            reentrantLock.unlock();
            System.out.println("three over");
        });
        one.start();
        try {TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {}
        two.start();
        try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {}
        three.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("线程被打断");
        }
        LockSupport.unpark(three);
    }
}
