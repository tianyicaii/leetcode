/*
 *  http://www.lintcode.com/en/problem/permutation-index/
 *
 *  Given a permutation which contains no repeated number, find its index in all the permutations of these numbers,
 *  which are ordered in lexicographical order. The index begins at 1.
 */
	
	public long permutationIndex (int[] A) {

		long[] factorial = new long[A.length + 1];  // number of permutation of n elements is factorial(n)
		factorial[0] = 1;
		for (int i = 1; i <= A.length; i++)
			factorial[i] = factorial[i-1] * i;

		
		long ans = 1;
		

		for (int i = 0; i < A.length - 1; i++)  // count how many numbers are there before A[i] is at position i
			for (int j = i + 1; j < A.length; j++)
				if (A[j] < A[i]) ans += factorial[A.length - (i + 1)];
		
		return ans;
	}
