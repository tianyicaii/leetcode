// https://leetcode.com/problems/h-index/


public class Solution {
	

	public int hIndex (int[] citations) {
		if (citations == null || citations.length == 0) return 0;
		
		int[] counts = new int[citations.length + 1];
		for (int i : citations) {
			if (i >= citations.length) counts[citations.length] += 1;
			else                       counts[i] += 1;
		}
		
		
		int h = citations.length;
		int n = counts[h];
		while (h >= 1 && n < h) {
			h -= 1;
			n += counts[h];
		}

		return h;
	}


}

