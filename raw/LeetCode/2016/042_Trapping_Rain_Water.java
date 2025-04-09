// https://leetcode.com/problems/trapping-rain-water/


public class Solution {


	public int trap (int[] height) {
		
		if (height.length <= 2) return 0;
		int area = 0;
		
		int left = 0;
		int right = height.length - 1;
		int L = height[left];
		int R = height[right];
		
		while (left < right - 1) {
			if (L < R) {
				left += 1;
				if (height[left] <= L)
					area += L - height[left];
				else
					L = height[left];
			}
			else {
				right -= 1;
				if (height[right] <= R)
					area += R - height[right];
				else
					R = height[right];
			}
		}
		
		return area;
	}


}

