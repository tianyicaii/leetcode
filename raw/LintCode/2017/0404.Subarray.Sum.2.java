/*

http://www.lintcode.com/en/problem/subarray-sum-ii/

Given an integer array, find a subarray where the sum of numbers is in a given interval.
Your code should return the number of possible answers.
(The element in the array should be positive)

*/


	private int binarySearch (int[] prefixSum, int last, int sum) {  // find number of prefixes with sum <= given sum, find the last occurrence
		
		if (prefixSum[last] <= sum) return last + 1;
		if (prefixSum[0] > sum) return 0;
		
		int left = 0;
		int right = last;
		
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (prefixSum[mid] <= sum) left = mid;
			else right = mid;
		}
		
		return left + 1;
	}
	
	
	
	public int subarraySumII (int[] A, int start, int end) {
		
		int[] prefixSum = new int[A.length + 1];  // increasing sequence since A contains only positive numbers
		for (int i = 1; i <= A.length; i++) {
			prefixSum[i] = prefixSum[i-1] + A[i-1];
		}
		
		
		int ans = 0;
		for (int i = 1; i <= A.length; i++) {
			
			
			// prefix of length i => prefixSum[i]
			// find number of smaller prefixes with: sum >= prefixSum[i] - end && sum <= prefixSum[i] - start
			// since sum >= 0, valid number of prefixes is: number of prefix with sum <= prefixSum[i] - start, minus, the number of prefix with sum < prefixSum[i] - end;
			// which is equivalent to find: sum <= prefixSum[i] - start, minus, sum <= prefixSum[i] - end - 1;
		
			
			int a = binarySearch(prefixSum, i-1, prefixSum[i] - start);
			int b = binarySearch(prefixSum, i-1, prefixSum[i] - end - 1);
			ans += a - b;
		}
		
		return ans;
		
	}
