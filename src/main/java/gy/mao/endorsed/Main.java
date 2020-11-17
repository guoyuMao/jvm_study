package gy.mao.endorsed;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("--"+i+":"+list.get(i)+"--");
        }
    }
}
