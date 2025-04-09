package lintcode;

public class I0437CopyBooks {
    
    public int copyBooks(int[] pages, int k) {
        if (pages.length == 0) return 0;
        int left = 1;
        int right = 0;
        for (int p : pages) {
            left = Math.max(left, p);  // avoid inifity look
            right += p;
        }
        if (isValid(pages, k, left)) return left;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (isValid(pages, k, mid)) right = mid;
            else left = mid;
        }
        return right;
    }

    boolean isValid(int[] pages, int k, int t) {
        int cnt = 1;
        int r = t;
        for (int p : pages) {
            if (p > r) {
                cnt += 1;
                r = t;
            }
            r -= p;
        }
        if (cnt <= k) return true;
        return false;
    }
}
