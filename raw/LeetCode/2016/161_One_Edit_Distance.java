// https://leetcode.com/problems/one-edit-distance/


public class Solution {
	

	public boolean isOneEditDistance(String s, String t) {
		
		// if same length, replace one letter
		// if difference length, add/remove one letter
		
		int m = s.length();
		int n = t.length();
		if (m > n) return isOneEditDistance(t, s);
		
		if (n - m > 1) return false;
		
		if (m == n) {
			int i = 0;
			while (i < m && s.charAt(i) == t.charAt(i)) i++;
			if (i == m) return false;  // same
			i += 1;
			while (i < m && s.charAt(i) == t.charAt(i)) i++;
			if (i != m) return false;  // more than one pair differ
			else        return true;
		}
		else {  // t is longer by one letter
			int i = 0;
			while (i < m && s.charAt(i) == t.charAt(i)) i++;
			while (i < m && s.charAt(i) == t.charAt(i + 1)) i++;
			if (i == m) return true;
			else        return false;  // more than one pair differ
		}
	}	


}

