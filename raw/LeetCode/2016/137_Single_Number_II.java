// https://leetcode.com/problems/single-number-ii/


public class Solution {
	

	public int singleNumber (int[] nums) {
		
		int[] bits = new int[32];
		for (int v : nums) {
			for (int i = 0; i < 32; i++) {
				bits[i] = (bits[i] + ((v >> i) & 1)) % 3;
			}
		}
		int x = 0;
		for (int i = 0; i < 32; i++) {
			if (bits[i] != 0)
				x |= (1 << i);
		}
		return x;
	}


}

