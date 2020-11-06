package gy.mao;

/**
 * Created by guoyu.mao on 2019/7/3.
 * Email:maoguoyu@ewell.cc
 */
public class MutablePoint {
    public int x;
    public int y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint point) {
        this.x = point.x;
        this.y = point.y;
    }
}
