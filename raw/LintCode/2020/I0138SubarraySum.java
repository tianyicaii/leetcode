package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class I0138SubarraySum {
    
    public List<Integer> subarraySum(int[] nums) {
        Map<Integer, Integer> sum2length = new HashMap<>();
        sum2length.put(0, 0);
        int prefixSum = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum += nums[i-1];
            if (sum2length.containsKey(prefixSum)) {
                List<Integer> ans = new ArrayList<>();
                ans.add(sum2length.get(prefixSum));
                ans.add(i-1);
                return ans;
            } else {
                sum2length.put(prefixSum, i);
            }
        }
        throw new IllegalArgumentException();
    }

}
