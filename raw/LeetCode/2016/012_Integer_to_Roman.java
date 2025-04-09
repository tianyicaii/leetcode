// https://leetcode.com/problems/integer-to-roman/


public class Solution {


	int[]    INTEGERS = new int[]    {1000, 900 , 500, 400 , 100, 90  , 50 , 40  , 10 , 9   , 5  , 4   , 1   };
	String[] ROMANS   = new String[] {"M" , "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" }; 
	
	
	public String intToRoman(int num) {
		StringBuilder ans = new StringBuilder();
		
		for (int i = 0; i < INTEGERS.length; i++) {
			while (num >= INTEGERS[i]) {
				ans.append(ROMANS[i]);
				num -= INTEGERS[i];
			}
		}
		
		return ans.toString();
	}
	

}

