// https://leetcode.com/problems/product-of-array-except-self/


public class Solution {


	public int[] productExceptSelf (int[] nums) {
		
		
		/*
		 *    1  2  3  4  5
		 *    1  1  1  1  1  // except itself
		 *    1  1  2  6 24  // left  side accumulate
		 *  120 60 20  5  1  // right side accumulate
		 *  120 60 40 30 24
		 */
		
		
		int[] L = new int[nums.length];
		int[] R = new int[nums.length];
		int[] A = new int[nums.length];
		
		Arrays.fill(L, 1);  // avoid nums.length == 0;
		Arrays.fill(R, 1);
		
		for (int i = 1; i < nums.length; i++) {
			L[i] = L[i-1] * nums[i-1];  // dp space optimization here
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			R[i] = R[i+1] * nums[i+1];
		}
		for (int i = 0; i < nums.length; i++) {
			A[i] = L[i] * R[i];
		}
		return A;
	}	


}

