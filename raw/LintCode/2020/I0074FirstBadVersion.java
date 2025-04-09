package lintcode;

public class I0074FirstBadVersion {
    
    
    public static class SVNRepo {
        public static boolean isBadVersion(int k) { return false; }
    }


    public int findFirstBadVersion(int n) {
        if (SVNRepo.isBadVersion(0)) return 0;

        int left = 0;
        int right = n;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (SVNRepo.isBadVersion(mid)) right = mid;
            else left = mid;
        }
        return right;
    }

}
