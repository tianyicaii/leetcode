/*

http://www.lintcode.com/en/problem/continuous-subarray-sum/

Given an integer array, find a continuous subarray where the sum of numbers is the biggest.
Your code should return the index of the first number and the index of the last number.
(If their are duplicate answer, return anyone)

*/


	class Range {
		int start;
		int end;
		int sum;  // keep indices along with sum
		public Range (int start, int end, int sum) {
			this.start = start;
			this.end = end;
			this.sum = sum;
		}
	}
	
	public List<Integer> continuousSubarraySum (int[] A) {
		
		Range[] local = new Range[A.length];  // sub array that has to end at i
		Range[] global = new Range[A.length];

		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				local[0] = new Range(0, 0, A[0]);
				global[0] = local[i];
			} else {
				if (local[i-1].sum > 0) {  // glue current one to the previous end, indicates greedy
					local[i] = new Range(local[i-1].start, i, local[i-1].sum + A[i]);
				} else {  // start a new range, discard previous negative sum
					local[i] = new Range(i, i, A[i]);
				}
				if (local[i].sum > global[i-1].sum) {
					global[i] = local[i];  // keep the max seen so far
				} else {
					global[i] = global[i-1];
				}
			}
		}
	
		List<Integer> ans = new ArrayList<>();
		ans.add(global[A.length - 1].start);
		ans.add(global[A.length - 1].end);
		return ans;
	}
