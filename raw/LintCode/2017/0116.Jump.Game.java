/*
 *  http://www.lintcode.com/en/problem/jump-game/
 *
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *  Each element in the array represents your maximum jump length at that position.
 *  Determine if you are able to reach the last index.
 */


// dp
	public boolean canJump (int[] A) {

		//  is it possible to reach A[i] from A[0] ?

		boolean[] B = new boolean[A.length];
		for (int i = 0; i < A.length; i++) {
			if (i == 0) B[i] = true;
			for (int j = 0; j < i && !B[i]; j++) {
				if (B[j] && j + A[j] >= i) B[i] = true;
			}
		}
		
		return B[A.length - 1];
	}	




// backwards
	public boolean canJump (int[] A) {

		//  is it possible to reach A[A.length - 1] from A[i] ?

		boolean[] B = new boolean[A.length];
		for (int i = A.length - 1; i >= 0; i--) {
			if (i == A.length - 1) B[i] = true;
			else {
				for (int j = 1; j <= A[i] && !B[i]; j++) {
					if (B[i + j]) B[i] = true;
				}
			}
		}
		
		return B[0];
	}	
