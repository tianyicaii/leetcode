// https://leetcode.com/problems/rectangle-area/


public class Solution {


	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		
		int dx;
		if (E >= C || G <= A) dx = 0;
		else {
			int[] X = new int[] {A, E, C, G};
			Arrays.sort(X);	
			dx = X[2] - X[1];
		}
		int dy;
		if (F >= D || H <= B) dy = 0;
		else {
			int[] Y = new int[] {F, B, H, D};
			Arrays.sort(Y);
			dy = Y[2] - Y[1];
		}
		
		return (A - C) * (B - D) + (E - G) * (F - H) - dx * dy;
		
	}


}

