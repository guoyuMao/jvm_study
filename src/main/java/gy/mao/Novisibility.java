package gy.mao;

/**
 * Created by guoyu.mao on 2019/7/2.
 * Email:maoguoyu@ewell.cc
 */
public class Novisibility {
    private volatile static boolean ready = false;
    private volatile static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                System.out.println(number);
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        Thread.yield();
        number = 42;
        ready = true;
        Thread.yield();
        System.out.println("number"+number);

    }
}
