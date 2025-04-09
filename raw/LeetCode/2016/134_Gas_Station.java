// https://leetcode.com/problems/gas-station/


public class Solution {
	

	public int canCompleteCircuit (int[] gas, int[] cost) {
		
		int G = 0;
		int C = 0;
		
		for (int g : gas) {
			G += g;
		} 
		for (int c : cost) {
			C += c;
		}
		
		if (G < C)
			return -1;
		
		int remaining = 0;
		int start = 0;
		for (int i = 0; i < gas.length; i++) {
			remaining += gas[i] - cost[i];
			if (remaining < 0) {
				start = i + 1;
				remaining = 0;
			}
		}
		return start;
	}


}

