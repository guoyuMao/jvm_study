package gy.mao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

public class TestCollection {

    @Test
    public void testArrayList() {
        ArrayList<Long> list = new ArrayList<>();
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 100000; i++) {
            list.add(System.currentTimeMillis());
        }

        for (int i = 99900; i < 100000; i++) {
            System.out.println(list.get(i) - list.get(i - 1));
        }
    }

    @Test
    public void testHashMap() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            map.put(i, i);
        }
    }
}
