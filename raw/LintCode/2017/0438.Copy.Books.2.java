/*
 *  http://www.lintcode.com/en/problem/copy-books-ii/
 *
 *  Given n books( the page number of each book is the same) and an array of integer with size k means k people to copy the book and the i th integer is the time i th person to copy one book).
 *  You must distribute the continuous id books to one people to copy. (You can give book A[1],A[2] to one people, but you cannot give book A[1], A[3] to one people, because book A[1] and A[3] is not continuous.)
 *  Return the number of smallest minutes need to copy all the books.
 *
 */


// assigning consecutive books to one worker means subproblem is not depeneded on problem size.
// a later worker cannot jump to front and get a book.


	public int copyBooksII (int n, int[] times) {
		
		Arrays.sort(times);  // fastest copiers first
		int [][] M = new int[2][n + 1];
		for (int i = 0; i < Math.min(times.length, n); i++) {
			for (int j = 1; j <= n; j++) {  // number of books for worker[i] to copy
				
				
				if (i == 0) M[i % 2][j] = M[i % 2][j-1] + times[i];
				else {
					M[i % 2][j] = Integer.MAX_VALUE;
					
					for (int k = j, lastTime = 0; k >= 0 && lastTime < M[(i-1) % 2][k]; k--) {  // starting index of books assigned to copier i
						if (k == j) lastTime = 0;  // zero book to start with
						else lastTime += times[i];  // one more book to copy
						M[i % 2][j] = Math.min(M[i % 2][j], Math.max(lastTime, M[(i-1) % 2][k]));
					}					
				}

				
			}
		}
		
		return M[(Math.min(times.length, n) - 1) % 2][n];
		
	}
