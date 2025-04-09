package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class I0057ThreeSum {
    

    List<List<Integer>> ans;
    int[] nums;
    int N;

    public List<List<Integer>> threeSum(int[] numbers) {

        ans = new ArrayList<>();
        nums = numbers;
        N = numbers.length;
        Arrays.sort(numbers);

        for (int first = 0; first < N - 2; ) {
            twoSum(first);
            first = findNextDistinct(first);
        }
        return ans;
    }

    private void twoSum(int first) {
        
        for (int second = first + 1, third = N - 1; second < third; ) {
            int sum = nums[first] + nums[second] + nums[third];
            if (sum == 0) {
                addResult(first, second, third);
                second = findNextDistinct(second);
                third = findPrevDistinct(third);
            } else if (sum < 0) {
                second = findNextDistinct(second);
            } else {
                third = findPrevDistinct(third);
            }
        }
    }

    private void addResult(int x, int y, int z) {
        List<Integer> triple = new ArrayList<>();
        triple.add(nums[x]);
        triple.add(nums[y]);
        triple.add(nums[z]);
        ans.add(triple);
    }

    private int findNextDistinct(int i) {
        while (i < nums.length - 1 && nums[i] == nums[i+1]) i++;
        return i+1;
    }

    private int findPrevDistinct(int i) {
        while (i >= 1 && nums[i] == nums[i-1]) i--;
        return i-1;
    }
}
