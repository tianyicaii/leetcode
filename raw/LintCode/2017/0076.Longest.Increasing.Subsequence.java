/*
 *  http://www.lintcode.com/en/problem/longest-increasing-subsequence/
 *
 *  Given a sequence of integers, find the longest increasing subsequence (LIS).
 *  You code should return the length of the LIS.
 */


	public int longestIncreasingSubsequence (int[] nums) {

		if (nums.length == 0) return 0;
		int max = 1;
		int[] A = new int[nums.length];  // max length in prefix including A[i]
		Arrays.fill(A, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {  // we don't know which of preceding element give the optimal result
				if (nums[i] > nums[j]) {
					A[i] = Math.max(A[i], A[j] + 1);  //  have to visit all previous elements to find max.
				}
			}
			max = Math.max(max, A[i]);
		}
		return max;
	}



//  relaxation:
//  a smaller elements can replace a larger elements
//  and does not affact the result for a larger prefix

	public int longestIncreasingSubsequence (int[] nums) {

		//  use smaller elements to as a representative, and replace the larger element before it
		//  in the hope to find a longer increasing subsequence
		
		int m = nums.length;
		int[] A = new int[m];
		Arrays.fill(A, Integer.MAX_VALUE);
		int max = 0;
		for (int i : nums) {
			int index = b_search(A, i);
			A[index] = i;
			max = Math.max(max, index + 1);
		}
		return max;
	}
	
	//  find first elements >= A, to maintain that elements in A increases
	int b_search (int[] A, int i) {
		int left = 0;
		int right = A.length - 1;
		if (A[left] >= i) return left;
		if (A[right] < i) return -1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			int M = A[mid];
			if (M < i) left = mid;
			else right = mid;
		}
		return right;
	}
