package gy.mao.thread;

public class ThreadInterrupt {
    static Object o = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (o){
                System.out.println("111111111111111");
                try {
                    System.out.println("thread sleep");
                    Thread.sleep(5000l);
                    System.out.println("thread is weak");
                    o.wait();
                    System.out.println("222222222222222222222");
                } catch (InterruptedException e) {
                    System.out.println("444444444");
                }
                System.out.println("3333333333333333");
            }
        });
        t1.start();
//        Thread t2 = new Thread(() -> {
//            synchronized (o){
//                System.out.println("aaaaaaaaaaaaaaaaaaa");
//                try {
//                    o.wait();
//                    System.out.println("bbbbbbbbbbbbbbbbbbbbbb");
//                } catch (InterruptedException e) {
//                    System.out.println("ddddddddddddddddddd");
//                }
//                System.out.println("cccccccccccccccc");
//            }
//        });
//        t2.start();
        Thread.sleep(1000l);
        System.out.println("------------");
        t1.interrupt();
        System.out.println("===============");

    }
}
