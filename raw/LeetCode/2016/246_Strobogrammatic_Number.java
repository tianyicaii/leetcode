// https://leetcode.com/problems/strobogrammatic-number/


public class Solution {


	public boolean isStrobogrammatic (String num) {
		int i = 0;
		int j = num.length() - 1;
		while (i <= j) {
		
			if (i == j) {
				int x = num.charAt(i) - '0';
				if (!(x == 0 || x == 1 || x == 8)) return false;
			}
			else {
				int left  = num.charAt(i) - '0';
				int right = num.charAt(j) - '0';
				if (!((left == 0 && right == 0) ||
					  (left == 1 && right == 1) ||
					  (left == 8 && right == 8) ||
					  (left == 6 && right == 9) ||
					  (left == 9 && right == 6))) return false;
			}
			i++; j--;
		}
		return true;
	}


}

