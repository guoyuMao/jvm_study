package gy.mao.thread;

public class WaitNotifyTest2 {
    static class Object{}

    public static void main(String[] args) throws InterruptedException{
        boolean bool = true;
        Object o = new Object();
        new Thread(()->{
            synchronized (o){
                System.out.println("thread1 get lock");
                o.notifyAll();//通知别的线程运行
                try {
                    System.out.println("thread1 is already notify,next step will to sleep");
                    Thread.sleep(5000l);
                    System.out.println("thread1 is already notify,next step will to run wait()");
                    o.wait();
                    System.out.println("thread1 is continue run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread1 is over!");
        }).start();
        new Thread(()->{
            synchronized (o){
                o.notifyAll();
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 get lock");
                o.notifyAll();
            }
            System.out.println("thread2 is over!");
        }).start();
    }
}
