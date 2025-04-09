/*
 *  http://www.lintcode.com/en/problem/stone-game/#
 *
 *  There is a stone game.At the beginning of the game the player picks n piles of stones in a line.
 *  The goal is to merge the stones in one pile observing the following rules:
 *      At each step of the game,the player can merge two adjacent piles to a new pile.
 *      The score is the number of stones in the new pile.
 *      You are to determine the minimum of the total score.
 */


	public int stoneGame (int[] A) {
		if (A.length < 2) return 0;  // no merge, no point

		
		int[] prefixSums = new int[A.length + 1];  // points equal the sum of some sub-array
		for (int i = 1; i <= A.length; i++) {
			prefixSums[i] = prefixSums[i - 1] + A[i - 1];
		}
		
		
		int[][] m = new int[A.length + 1][A.length];  // length of the sub-array, offset of start of the sub-array
		for (int i = 1; i <= A.length; i++) {  // length of sub-array
			for (int j = 0; j + i <= A.length; j++) {  // starting offset of sub-array
				
				
				if (i == 1) m[i][j] = A[j];  // still needed in order to find sub-array of length 2
				else {
					m[i][j] = Integer.MAX_VALUE;
					for (int k = 1; k < i; k++) {  // length of left division of sub-array
						int sum = prefixSums[j + i] - prefixSums[j];  // points for this merge
						if (k > 1) sum += m[k][j];  // points for previous merges
						if (i - k > 1) sum += m[i - k][j + k];  // points for previous merges
						m[i][j] = Math.min(m[i][j], sum);
					}
				}
				
				
			}
		}

		
		return m[A.length][0];
	}	
