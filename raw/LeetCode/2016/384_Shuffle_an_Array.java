// https://leetcode.com/problems/shuffle-an-array/


public class Solution {


	int[] original;


    public Solution(int[] nums) {
        original = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ans = new int[original.length];
        for (int i = 0; i < original.length; i++) {
        	ans[i] = original[i];
        }
        for (int i = 0; i < original.length; i++) {
        	int j = (int) (Math.random() * (original.length - i)) + i;
        	swap(ans, i, j);
        }
        return ans;
    }

    private void swap (int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }

}

