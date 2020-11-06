package gy.mao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by guoyu.mao on 2019/7/4.
 * Email:maoguoyu@ewell.cc
 */
public class Mytest {
    public static void main(String[] args) {
        List<Integer> charList = new ArrayList<>();
        for(int i = 0; i < 10000; i ++) {
            charList.add(i);
        }
        

        List<Integer> syList = Collections.synchronizedList(charList);
    }
}
