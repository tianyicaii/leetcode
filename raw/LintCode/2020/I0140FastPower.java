package lintcode;

public class I0140FastPower {
    
    public int fastPower(int a, int b, int n) {
        if (n == 0) return 1 % b;
        if (n == 1) return a % b;

        long halfN = fastPower(a, b, n/2);
        long ans = (halfN * halfN) % b;
        if (n % 2 == 1) ans = (ans * a) % b;
        return (int)ans;
    }
}
