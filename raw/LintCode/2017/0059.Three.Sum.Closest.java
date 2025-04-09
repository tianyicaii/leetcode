/*
 *  http://www.lintcode.com/en/problem/3sum-closest/
 *
 *  Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 *  Return the sum of the three integers.
 */

	public int threeSumClosest (int[] numbers, int target) {
		
		Arrays.sort(numbers);
		int ans = numbers[0] + numbers[1] + numbers[2];
		for (int i = 0; i < numbers.length - 2; i++) {
			int j = i + 1;
			int k = numbers.length - 1;
			while (j < k) {
				int sum = numbers[i] + numbers[j] + numbers[k];
				if (Math.abs(target - sum) < Math.abs(target - ans)) ans = sum;
				if (sum < target) j ++;
				else if (sum > target) k --;
				else return target;
			}

		}
		return ans;
	}
