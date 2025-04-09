import java.util.*;

public class Solution {


	public int[] twoSum (int[] nums, int target) {
		
		//  input is sorted
		
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			int y = target - x;
			int j = binarySearch(nums, y);
			if (j != -1) {
				if (i == j) {
					if (i - 1 >= 0 && nums[i - 1] == x) {
						return new int[] {i - 1, i};
					} else if (i + 1 < nums.length && nums[i + 1] == x) {
						return new int[] {i, i + 1};
					} else {
						continue;
					}
				} else {
					return new int[] {i, j};
				}
			} else {
				continue;
			}
		}
		
		return new int[] {};
	}
	
	public int binarySearch (int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (nums[middle] == target) return middle;
			else if (nums[middle] < target) left = middle + 1;
			else right = middle - 1;
		}
		return -1;
	}
}


import java.util.*;

public class Solution {


	public int[] twoSum (int[] nums, int target) {
		
		//  inductive hypothesis: number outside i and j cannot be one of the pair.
		
		int i = 0;
		int j = nums.length - 1;
		
		while (i < j) {
			int sum = nums[i] + nums[j];
			if (sum == target) {
				return new int[] {i + 1, j + 1};
			} else if (sum < target) {
				++ i;
			} else {
				-- j;
			}
		}
		
		return new int [] {};
	}

}
