package gy.mao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoyu.mao on 2019/4/28.
 * Eamil:maoguoyu@ewell.cc
 */
public class HeapOCM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
