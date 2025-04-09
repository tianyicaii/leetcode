/*
 *  http://www.lintcode.com/en/problem/find-peak-element-ii/
 *
 *  There is an integer matrix which has the following features:
 *      The numbers in adjacent positions are different.
 *      The matrix has n rows and m columns.
 *      For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
 *      For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
 *      We define a position P is a peek if:
 *          A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]
 *  Find a peak element in this matrix. Return the index of the peak.
 */


// need to use global maximum on the line to do bi-section
// distinguish local peak and global max


	public List<Integer> findPeakII (int[][] A) {
		int top = 0;
		int bottom = A.length - 1;
		while (top < bottom - 1) {
			int mid = top + (bottom - top) / 2;
			int j = findPeak(A[mid]);
			if (A[mid][j] > A[mid - 1][j] && A[mid][j] > A[mid + 1][j]) {
				List<Integer> ans = new ArrayList<>();
				ans.add(mid);
				ans.add(j);
				return ans;
			}
			if (A[mid][j] < A[mid - 1][j]) bottom = mid;
			else top = mid;
		}
		throw new RuntimeException("invalid input: " + top + ", " + bottom);
	}	
	
	int findPeak (int[] A) {
		int left = 0;
		int right = A.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) return mid;
			else if (A[mid] < A[mid - 1]) right = mid;
			else left = mid;
		}
		throw new RuntimeException("invalid input: " + Arrays.toString(A));
	}


// find global max among two mid lines
	public List<Integer> findPeakII (int[][] A) {
		
		int top = 1;
		int bottom = A.length - 2;
		int left = 1;
		int right = A[0].length - 2;
		
		while (true) {
			
			int r = (top + bottom) / 2;
			int c = (left + right) / 2;
			
			int max = A[r][c];
			int x = r;
			int y = c;
			

			// find globals on two middle lines
			for (int i = top; i <= bottom; i++) {
				if (A[i][c] > max) {
					max = A[i][c];
					x = i;
					y = c;
				}
			}
			for (int j = left; j <= right; j++) {
				if (A[r][j] > max) {
					max = A[r][c];
					x = r;
					y = c;
				}
			}
			

			// reduce problem to one of the four quadrants

			if (A[x][y] < A[x-1][y]) {
				if (y < c) {
					bottom = r-1;
					right = c-1;
				} else {
					bottom = r-1;
					left = c+1;
				}
			} else if (A[x][y] < A[x+1][y]) {
				if (y < c) {
					top = r+1;
					right = c-1;
				} else {
					top = r+1;
					left = c+1;
				}
			} else if (A[x][y] < A[x][y-1]) {
				if (x < r) {
					right = c-1;
					bottom = r-1;
				} else {
					right = c-1;
					top = r+1;
				}
			} else if (A[x][y] < A[x][y+1]) {
				if (x < r) {
					left = c+1;
					bottom = r-1;
				} else {
					left = c+1;
					top = r+1;
				}
			} else {  // peak
				List<Integer> ans = new ArrayList<>();
				ans.add(x);
				ans.add(y);
				return ans;
			}
		}
	}
	