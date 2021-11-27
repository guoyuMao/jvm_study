package gy.mao;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by guoyu.mao on 2019/7/4.
 * Email:maoguoyu@ewell.cc
 */
public class Mytest {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> charList = new ArrayList<>();
        for(int i = 0; i < 10000; i ++) {
            charList.add(i);
        }
        

        List<Integer> syList = Collections.synchronizedList(charList);
/*        new Thread(()->{
            syList.add(5);
        }).start();

//        增加foreach 会使用迭代器
        for (Integer i : syList) {
            System.out.println(i);
        }

        for (int i = 0; i < syList.size(); i++) {
            System.out.println(syList.get(i));
        }*/
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int j = 0; j < 5; j++) {
            new Thread(()->{
                System.out.println("thred:"+Thread.currentThread()+"start");
                countDownLatch.countDown();
                for (int i = 0; i < 10000; i++) {
                    syList.add(i);
                }
                System.out.println("thred:"+Thread.currentThread()+"over");
            }).start();
        }
        TimeUnit.SECONDS.sleep(20L);

        System.out.println(syList.size());

    }

    @Test
    public void testHashMap() {
        Long l = Long.MAX_VALUE;
        System.out.println(l.hashCode());
    }

    @Test
    public void testCurrentHashMap() throws InstantiationException, IllegalAccessException {
//        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
//        for (int i = 0; i < 10; i++) {
//            concurrentHashMap.put(i, 'a' + i);
//        }
    }

    @Test
    public void testFinally() {
        for (int i = 0; i < 20; i++) {
            System.out.println("loop : + " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
                if (i == 5) {
                    throw new Exception();
                }
                continue;
            } catch (Exception e) {
                System.out.println("err");
            }finally {
                System.out.println("finally");
            }
        }
    }
}
