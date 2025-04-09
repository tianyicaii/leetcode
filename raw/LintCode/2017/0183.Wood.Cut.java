/*
 *  http://www.lintcode.com/en/problem/wood-cut/
 *
 *  Given n pieces of wood with length L[i] (integer array).
 *  Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length.
 *  What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
 */

	public int woodCut (int[] L, int k) {
		if (L.length == 0 || k <= 0) return 0;
		
		int min = 0;  // might not even able to serve a piece of length equal 1
		int max = L[0];  // at most the length of the longest piece
		for (int i : L) max = Math.max(max, i);
		
		if (isValid(L, k, max)) return max;
	
		while (max - min > 1) {
			int mid = min + (max - min) / 2;
			if (isValid(L, k, mid)) min = mid;
			else max = mid;
		}
		
		return min;
	}
	
	private boolean isValid (int[] L, int k, int guess) {  // find how many pieces if each piece has length = guess
		int count = 0;
		for (int i : L) count += i / guess;
		return count >= k;
	}
