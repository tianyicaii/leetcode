package lintcode;

public class I0414DivideTwoIntegers {
    

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long N = Math.abs((long)dividend);
        long D = Math.abs((long)divisor);

        int Q = 0;
        while (N >= D) {
            long cnt = 1;
            long exp = D;
            while (N >= exp) {
                cnt <<= 1;
                exp <<= 1;
            }
            cnt >>= 1;
            exp >>= 1;

            N -= exp;
            Q += cnt;
        }

        return isNeg ? -Q : Q;
    }
}
