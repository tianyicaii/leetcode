// https://leetcode.com/problems/roman-to-integer/


public class Solution {


	Map<Character, Integer> ROMAN_2_INTEGER = new HashMap<Character, Integer>() {{
		put('M', 1000);
		put('D',  500);
		put('C',  100);
		put('L',   50);
		put('X',   10);
		put('V',    5);
		put('I',    1);		
	}};
	
	public int romanToInt (String s) {
		
		int ans = 0;
		int R   = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			int C = ROMAN_2_INTEGER.get(s.charAt(i));
			if (C >= R) ans += C;
			else        ans -= C;
			R = C;
		}
		
		return ans;
	}


}

