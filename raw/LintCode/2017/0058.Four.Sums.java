/*
 *  http://www.lintcode.com/en/problem/4sum/#
 *
 *  Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 *  Find all unique quadruplets in the array which gives the sum of target.
 */

	public List<List<Integer>> fourSum(int[] numbers, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(numbers);

		for (int a = 0;  ; a++) {
			while (a < numbers.length - 3 && a != 0 && numbers[a] == numbers[a-1]) a++;
			if (a >= numbers.length - 3) break;  // input.length might less than 4


			for (int b = a + 1;  ; b++) {
				while (b < numbers.length - 2 && b != a + 1 && numbers[b] == numbers[b-1]) b++;
				if (b == numbers.length - 2) break;


				int c = b + 1;
				int d = numbers.length - 1;
				while (true) {
					while (c < d && c != b + 1 && numbers[c] == numbers[c-1]) c++;
					while (c < d && d != numbers.length - 1 && numbers[d] == numbers[d+1]) d--;
					if (c >= d) break;
					

					int sum = numbers[a] + numbers[b] + numbers[c] + numbers[d];
					if (sum == target) {
						List<Integer> q = new ArrayList<>();
						q.add(numbers[a]);
						q.add(numbers[b]);
						q.add(numbers[c]);
						q.add(numbers[d]);						
						ans.add(q);
						c++;
						d--;
					} else if (sum < target) {
						c++;
					} else {
						d--;
					}
				}
			}
		}
		return ans;
	}
