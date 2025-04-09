// https://leetcode.com/problems/h-index-ii/


public class Solution {
	

	// binary search on value


	public int hIndex (int[] citations) {
		if (citations == null || citations.length == 0) return 0;
				
		if (citations[0] >= citations.length) return citations.length;  // worst paper is too good
		if (citations[citations.length - 1] <= 0) return 0;  // best paper is rubbish
		
		int min = 0;
		int max = citations.length;
			
		while (min < max - 1) {
			int h = min + (max - min) / 2;  // guess h index
			int c = citations[citations.length - h];
			if (c >= h) min = h; 
			else max = h;
		}
		return min;
	}	


}

