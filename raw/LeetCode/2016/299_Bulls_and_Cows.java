// https://leetcode.com/problems/bulls-and-cows/


public class Solution {
	

	public String getHint(String secret, String guess) {
		int[] counts = new int[10];
		int bulls = 0;
		int cows = 0;
		for (int i = 0; i < secret.length; i++) {
			char s = secret.charAt(i);
			char g =  guess.charAt(i);
			if (s == g) bulls ++;
			else {
				if (counts[s - '0']++ < 0) cows += 1;
				if (counts[g - '0']-- > 0) cows += 1;
			}
		}
		return bulls + "A" + cows + "B";
	}


}


