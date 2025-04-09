/*

http://www.lintcode.com/en/problem/continuous-subarray-sum-ii/

Given an circular integer array (the next element of the last element is the first element),
find a continuous subarray in it, where the sum of numbers is the biggest.
Your code should return the index of the first number and the index of the last number.
If duplicate answers exist, return any of them.

*/


	class Range {
		int start;
		int end;
		int sum;
		public Range (int start, int end, int sum) {
			this.start = start;
			this.end = end;
			this.sum = sum;
		}
	}
	
	public List<Integer> continuousSubarraySumII (int[] A) {
		
//  find max in the middle
		Range[] local = new Range[A.length];  // sub-array that has to end at i
		Range[] global = new Range[A.length];

		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				local[0] = new Range(0, 0, A[0]);
				global[0] = local[i];
			} else {
				if (local[i-1].sum > 0) {  // indicates greedy
					local[i] = new Range(local[i-1].start, i, local[i-1].sum + A[i]);
				} else {
					local[i] = new Range(i, i, A[i]);
				}
				if (local[i].sum > global[i-1].sum) {
					global[i] = local[i];
				} else {
					global[i] = global[i-1];
				}
			}
		}

		Range max = global[A.length - 1];


//  find min in the middle
		local = new Range[A.length];  // sub array that has to end at i
		global = new Range[A.length];

		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				local[0] = new Range(0, 0, A[0]);
				global[0] = local[i];
			} else {
				if (local[i-1].sum < 0) {  // indicates greedy
					local[i] = new Range(local[i-1].start, i, local[i-1].sum + A[i]);
				} else {
					local[i] = new Range(i, i, A[i]);
				}
				if (local[i].sum < global[i-1].sum) {
					global[i] = local[i];
				} else {
					global[i] = global[i-1];
				}
			}
		}
		
		Range min = global[A.length - 1];

		
//  global maximum can be either the max seen in the middle,
//  or the entire array minus the min seen in the middle.
//
//  min could be the entire array, and we need to find a non-empty result.
//  in that case, the max cannot occur as two segments,
//  otherwise, the minimum will not be entire array


		List<Integer> ans = new ArrayList<>();
		if (min.start == 0 && min.end == A.length - 1) {  // min is entire array
			ans.add(max.start);
			ans.add(max.end);
			return ans;
			
		} else {  // choose one
			int sum = 0;  // total sum of entire array
			for (int i : A) sum += i;
			
			if (sum - min.sum > max.sum) {
				ans.add((min.end + 1) % A.length);
				ans.add((min.start - 1 + A.length) % A.length);
				return ans;
				
			} else {
				ans.add(max.start);
				ans.add(max.end);
				return ans;
			}
		}
				
	}
