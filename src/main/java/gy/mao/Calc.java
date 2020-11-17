package gy.mao;

public class Calc {


    public static void main(String[] args) {
        System.out.println(count(20));
        System.out.println(count(20));

    }

    static int count(int num) {
        if (num <= 2) {
            return num;
        }
        return count(num - 1) + count(num - 2);
    }

    static int countWays(int n) {
        // write code here
        if(n<=2)
            return n;
        int f = 1%1000000007;
        int s = 2%1000000007;
        int t = 0;
        for(int i=3;i<=n;i++){
            t = (f+s)%1000000007;
            f = s;
            s = t;
        }
        return t;
    }
}
