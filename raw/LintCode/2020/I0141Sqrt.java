package lintcode;

public class I0141Sqrt {
    
    public int sqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;

        int left = 1;
        int right = x;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            long square = (long)mid * mid;
            if (square <= x) left = mid;
            else right = mid;
        }

        return left;

    }
}
