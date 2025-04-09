// https://leetcode.com/problems/excel-sheet-column-title/


public class Solution {


	public String convertToTitle (int n) {

		StringBuilder ans = new StringBuilder();
		// char before 'A' is '@', zero in base 26. Z == A@
		do {
			char d = (char)(n % 26 + '@');
			ans.append(d);
			n /= 26;
		} while (n != 0);

		// convert '@' to 'Z'
		// X@ == WY + 1 == XZ
		// X@@ == WYY + 1 == WYZ
		// A@ == Y + 1 == Z
		// A@@ == YY + 1 == YZ
		
		boolean borrowing = false;
		for (int i = 0; i < ans.length(); i++) {
			if (ans.charAt(i) == '@') {
				if (borrowing) ans.setCharAt(i, 'Y');  // still borrowing
				else {
					borrowing = true;
					ans.setCharAt(i, 'Z');
				}
			}
			else {
				if (borrowing) {
					ans.setCharAt(i, (char)(ans.charAt(i) - 1));
					borrowing = false;
					i--;  // might be 'A' turns into '@'
				}
				else {
					;
				}
			}
		}
		
		ans.reverse();
		if (borrowing) return ans.substring(1);  // ignore first digit.
		else           return ans.toString();
	}	


}

