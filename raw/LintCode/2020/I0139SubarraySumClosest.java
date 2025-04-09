package lintcode;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class I0139SubarraySumClosest {
    

    public int[] subarraySumClosest(int[] nums) {

        TreeMap<Integer, Integer> sum2length = new TreeMap<>();
        sum2length.put(0, 0);
        int prefixSum = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum += nums[i-1];
            if (sum2length.containsKey(prefixSum)) return new int[] {sum2length.get(prefixSum), i-1};
            sum2length.put(prefixSum, i);
        }
        

        Iterator<Map.Entry<Integer, Integer>> it = sum2length.entrySet().iterator();
        int prev = it.next().getKey();
        int min = Integer.MAX_VALUE;
        int first = 0;
        int second = 0;
        while (it.hasNext()) {
            int curr = it.next().getKey();
            if (curr - prev <= min) {  // against [Integer.MAX_VALUE]
                min = curr - prev;
                first = sum2length.get(prev);
                second = sum2length.get(curr);
            }
            prev = curr;
        }

        return new int[] {Math.min(first, second), Math.max(first, second) - 1};
    }
}
