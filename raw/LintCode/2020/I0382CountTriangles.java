package lintcode;

import java.util.Arrays;

public class I0382CountTriangles {
    
    public int triangleCount(int[] S) {
        Arrays.sort(S);
        int ans = 0;
        for (int i = S.length-1; i >= 2; i--) {
            int left = 0;
            int right = i-1;
            while (left < right) {
                int sum = S[left] + S[right];
                if (sum <= S[i]) {
                    left++;
                } else {
                    ans += (right - left);
                    right--;
                }
            }
        }
        return ans;
    }
}
