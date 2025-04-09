package lintcode;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class I0042MaximumSubarray2 {
    
    public int maxTwoSubArrays(List<Integer> nums) {

        int[] leftToRight = maxOneSubArray(nums);
        Collections.reverse(nums);
        int[] rightToLeft = maxOneSubArray(nums);
        int max = Integer.MIN_VALUE;
        int N = nums.size();
        for (int i = 1; i < N; i++) {
            max = Math.max(max, leftToRight[i] + rightToLeft[N - i]);
        }
        return max;
    }

    private int[] maxOneSubArray(List<Integer> nums) {
        int N = nums.size();
        int[] local = new int[N + 1];
        int[] global = new int[N + 1];

        Iterator<Integer> it = nums.iterator();
        if (it.hasNext()) {
            local[1] = it.next();
            global[1] = local[1];
        }

        for (int i = 2; it.hasNext(); i++) {
            int x = it.next();
            local[i] = Math.max(x, local[i-1] + x);
            global[i] = Math.max(global[i-1], local[i]);
        }

        return global;
    }
}
