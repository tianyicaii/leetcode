/*
 *  http://www.lintcode.com/en/problem/copy-books/
 *
 *  Given n books and the ith book has A[i] pages. You are given k people to copy the n books.
 *  n books list in a row and each person can claim a *continous* range of the n books.
 *  For example one copier can copy the books from ith to jth continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).
 *  They start copying books at the same time and they all cost 1 minute to copy 1 page of a book.
 *  What's the best strategy to assign books so that the slowest copier can finish at earliest time?
 *  Return the maximum number of pages assigned to one worker in order to minimize total time.
 */


// dynamic programming
	public int copyBooks (int[] pages, int k) {

		if (pages.length == 0 || k <= 0) return 0;
		if (k > pages.length) k = pages.length;  // each person at least gets one book 
		
		int[] prefixSum = new int[pages.length + 1];  // to get (pages[i] + ... page[j])
		for (int i = 1; i <= pages.length; i++) prefixSum[i] = prefixSum[i-1] + pages[i-1];
		
		int[][] m = new int[k + 1][pages.length + 1];
		for (int i = 1; i <= k; i++) {  // number of workers
			for (int j = 1; j <= pages.length; j++) {  // number of books
				
				if (i == 1) m[i][j] = prefixSum[j];
				else {
					m[i][j] = Integer.MAX_VALUE;
					for (int p = 1; p <= j; p++) {  // assign worker[i-1] p books
						m[i][j] = Math.min(m[i][j], Math.max(m[i-1][p-1], prefixSum[j] - prefixSum[p-1]));
					}
				}
				
			}
		}
		
		return m[k][pages.length];
	}


// binary search
	public int copyBooks (int[] pages, int k) {
		if (pages.length == 0 || k <= 0) return 0;
		int min = pages[0];  // at least the most heavy book
		int max = 0;  // at most one person copies all the books
		for (int i : pages) {
			min = Math.max(min, i);
			max += i;
		}
		
		if (isValid(pages, k, min)) return min;

		while (max - min > 1) {
			int mid = min + (max - min) / 2;
			if (isValid(pages, k, mid)) max = mid;
			else min = mid;
		}
		return max;
	}

	private boolean isValid (int[] pages, int k, int guess) {
		int sum = 0;
		int count = 1;
		for (int i : pages) {
			sum += i;
			if (sum > guess) {  // need another person
				count += 1;
				sum = i;
			}
		}
		return count <= k;
	}
