package gy.mao.hyperloglog;


import java.util.concurrent.ThreadLocalRandom;

public class PtTest1 {
    static class BitKeeper {

        private int maxbit;

        public void random() {
            long value = ThreadLocalRandom.current().nextLong(2L << 32);
            int bit = lowZeros(value);
            if (bit > this.maxbit) {
                this.maxbit = bit;
            }
        }

        private int lowZeros(long value) {
            int i = 0;
            for (; i < 32; i++) {
                if (value >> i << i != value) {
                    break;
                }
            }
            return i - 1;
        }
    }

    static class Experiment {

        private int n;
        private BitKeeper keeper;

        public Experiment(int n) {
            this.n = n;
            this.keeper = new BitKeeper();
        }

        public void work() {
            for (int i = 0; i < n; i++) {
                this.keeper.random();
            }
        }

        public void debug() {
            System.out
                    .printf("%d %.2f %d\n", this.n, Math.log(this.n) / Math.log(2), this.keeper.maxbit);
        }
    }

    public static void main(String[] args) {
        for (int i = 1000; i < 20000000; i += 100000) {
            Experiment exp = new Experiment(i);
            exp.work();
            exp.debug();
        }
    }
}
