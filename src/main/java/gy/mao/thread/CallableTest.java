package gy.mao.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            Thread.sleep(2000l);
            return 1;
        });
        new Thread(futureTask).start();
        System.out.println("-------");
        Integer i = futureTask.get();
        System.out.println(i);
        System.out.println("==============");

    }
}
