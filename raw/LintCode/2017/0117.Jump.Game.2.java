/*
 *  http://www.lintcode.com/en/problem/jump-game-ii/
 *
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *  Each element in the array represents your maximum jump length at that position.
 *  Your goal is to reach the last index in the minimum number of jumps.
 */


// BFS-like Relaxation
	public int jump (int[] A) {
		
		int[] M = new int[A.length];
		Arrays.fill(M, Integer.MAX_VALUE);
		M[0] = 0;


		for (int i = 0; i < A.length; i++) {
			if (M[i] == Integer.MAX_VALUE) continue;
			else {
				for (int j = 1; j <= A[i] && i + j < A.length; j++) {
					M[i + j] = Math.min(M[i + j], M[i] + 1);
				}
			}
		}
		
		
		
		return M[A.length - 1] == Integer.MAX_VALUE ? -1 : M[A.length - 1];
	}
