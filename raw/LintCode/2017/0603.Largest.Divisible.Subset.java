/*
 *  http://www.lintcode.com/en/problem/largest-divisible-subset/
 *  Given a set of distinct positive integers,
 *  find the largest subset such that every pair (Si, Sj) of elements
 *  in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 */


// solution of sub-problem does not change as problem size changes

	public List<Integer> largestDivisibleSubset (int[] nums) {
		
		int n = nums.length;
		int[] local = new int[n];
		int[] global = new int[n];
		int[] predecessor = new int[n];  // predecessor[i] label the path that lead to the optimal result for nums[i]
		
		Arrays.sort(nums);
		
		for (int i = 0; i < n; i++) {
			
			if (i == 0) {
				local[i] = 1;
				global[i] = 1;
				predecessor[i] = -1;
			} else {
				int max = 1;
				int pre = -1;
				for (int j = 0; j < i; j++) {  // for each smaller element, we don't know who will gives the optimal result
					if (nums[i] % nums[j] == 0) {
						if (1 + local[j] > max) {
							max = 1 + local[j];
							pre = j;
						}	
					}
				}
				local[i] = max;
				global[i] = Math.max(local[i], global[i-1]);
				predecessor[i] = pre;
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		for (int i = n-1; i >= 0; i--) {
			if (local[i] == global[n-1]) {
				ans.add(nums[i]);
				while (predecessor[i] != -1) {
					i = predecessor[i];
					ans.add(nums[i]);
				}
				// Collections.reverse(ans);
				break;
			}
		}
		
		return ans;
	}
