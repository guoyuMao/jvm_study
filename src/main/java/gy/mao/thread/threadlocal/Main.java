package gy.mao.thread.threadlocal;

import java.util.concurrent.Exchanger;

public class Main {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
//        for (int i = 0; ; i++) {
//            new Thread(()->{
//                threadLocal.set("A"+1);
//                System.out.println(threadLocal.get());
//            }).start();
//        }
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(()->{
            System.out.println("t1");
            String rr = null;
            try {
                rr = exchanger.exchange("A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1:"+rr);
        }).start();
        new Thread(()->{
            System.out.println("t2");
            String rr = null;
            try {
                rr = exchanger.exchange("B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2:"+rr);
        }).start();
    }
}
