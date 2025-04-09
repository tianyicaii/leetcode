import java.util.*;

public class Solution {

	public boolean isPalindrome (int x) {
		if (x < 0) return false;
		int y = 1;
		while (x / y >= 10) {
			y *= 10;
		}
		while (x != 0) {
			int left = x / y;
			int right = x % 10;
			if (left != right) return false;
			x = x % y;
			x = x / 10;
			y = y / 100;		
		}
		return true;
	}
	
	public static void main (String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.isPalindrome(1001));

	}

}
