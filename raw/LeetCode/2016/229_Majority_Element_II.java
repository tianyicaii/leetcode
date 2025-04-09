// https://leetcode.com/problems/majority-element-ii/


public class Solution {


	public List<Integer> majorityElement(int[] nums) {
		
		int candi1 = 0;
		int count1 = 0;
		int candi2 = 0;
		int count2 = 0;
		
		for (int i : nums) {
			
			if (i == candi1) {
				count1 ++;
			}
			else if (i == candi2) {
				count2 ++;
			}
			else if (count1 == 0) {  // fill in
				candi1 = i;
				count1 = 1;
			}
			else if (count2 == 0) {  // fill in
				candi2 = i;
				count2 = 1;
			}
			else {  // reduce one triple
				count1 -= 1;
				count2 -= 1;
			}
		}
		
		
		// verify
		List<Integer> ans = new ArrayList<>();
		if (count1 != 0) {
			count1 = 0;
			for (int i : nums) {
				if (i == candi1) count1 ++;
			}
			if (count1 > nums.length / 3) ans.add(candi1);
		}
		if (count2 != 0) {
			count2 = 0;
			for (int i : nums) {
				if (i == candi2) count2 ++;
			}
			if (count2 > nums.length / 3) ans.add(candi2);
		}
		
		return ans;
	}


}

