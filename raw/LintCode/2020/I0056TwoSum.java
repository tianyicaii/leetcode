package lintcode;

import java.util.HashMap;
import java.util.Map;

public class I0056TwoSum {
    
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            int y = target - x;
            if (pos.containsKey(y)) {
                return new int[] {pos.get(y), i};
            }
            pos.put(x, i);
        }
        return null;
    }
}
