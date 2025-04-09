/*
 *  http://www.lintcode.com/en/problem/stone-game-ii/
 *
 *  There is a stone game.At the beginning of the game the player picks n piles of stones in a circle.
 *  The goal is to merge the stones in one pile observing the following rules:
 *
 *      At each step of the game,the player can merge two adjacent piles to a new pile.
 *      The score is the number of stones in the new pile.
 *      You are to determine the minimum of the total score.
 */


	public int stoneGame2(int[] A) {
		if (A.length < 2) return 0;  // no merge, no point
		int[] AA = new int[A.length * 2];  // find a sub-interval of length A.length inside an array of length 2 * A.length
		for (int i = 0; i < A.length; i++) {  // make it circular
			AA[i] = A[i];
			AA[A.length + i] = A[i];
		}
		return stoneGame(AA, A.length);
	}
	
	
	public int stoneGame (int[] A, int length) {
		
		int[][] m = new int[length + 1][A.length];
		int[] prefixSums = new int[A.length + 1];
		
		for (int i = 1; i <= A.length; i++) {
			prefixSums[i] = prefixSums[i - 1] + A[i - 1];
		}
		
		
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j + i <= A.length; j++) {
				if (i == 1) m[i][j] = A[j];
				else {
					m[i][j] = Integer.MAX_VALUE;
					for (int k = 1; k < i; k++) {
						int sum = prefixSums[j + i] - prefixSums[j];  // points for this merge
						if (k > 1) sum += m[k][j];  // points for previous merges
						if (i - k > 1) sum += m[i - k][j + k];  // points for previous merges
						m[i][j] = Math.min(m[i][j], sum);
					}
				}
			}
		}

		
		int ans = m[length][0];  // search in the last row and find min
		for (int j = 1; j + length <= A.length; j++) {
			ans = Math.min(ans, m[length][j]);
		}
		return ans;
	}	
