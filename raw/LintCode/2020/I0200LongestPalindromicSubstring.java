package lintcode;

public class I0200LongestPalindromicSubstring {
    

    String s;
    int N;
    int left;
    int right;

    public String longestPalindrome(String s) {
        this.s = s;
        N = s.length();
        left = 0;
        right = 0;
        for (int i = 0; i < N; i++) {
            expand(i, i);
        }
        for (int i = 0; i < N-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) expand(i, i+1);
        }
        return s.substring(left, right + 1);
    }

    private void expand(int l, int r) {
        while (l >= 1 && r <= N-2 && s.charAt(l-1) == s.charAt(r+1)) { l--; r++; }
        if (r - l + 1 > right - left + 1) { left = l; right = r; }
    }

}
