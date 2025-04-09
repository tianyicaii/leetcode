// https://leetcode.com/problems/reverse-bits/


public class Solution {


	Map<Integer, Integer> bytes = new HashMap<>();
	
	public int reverseBits(int n) {
		
		int ans = 0;
		for (int i = 0; i < 4; i++) {
			
			ans = ans << 8;
			ans = ans | reverseByte((n >> i * 8) & 0xff);
			
		}
		return ans;
	}
	
	private int reverseByte (int n) {
		
		if (bytes.containsKey(n)) return bytes.get(n);
		int ans = 0;
		
		for (int i = 0; i < 8; i++) {
			ans = ans << 1;
			ans = ans | ((n >> i) & 1);
		}
		
		bytes.put(n, ans);
		return ans;
	}


}

