/*
 *  http://www.lintcode.com/en/problem/3sum/
 *
 *  Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 *  Find all unique triplets in the array which gives the sum of zero.
 */

	List<List<Integer>> ans;
	
	public List<List<Integer>> threeSum (int[] numbers) {
		ans = new ArrayList<>();
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			if (i != 0 && numbers[i] == numbers[i - 1]) continue;
			twoSum(i, numbers);
		}
		return ans;
	}
	
	void twoSum (int first, int[] numbers) {
		int left = first + 1;
		int right = numbers.length - 1;
		while (true) {
			
			while (left < right && left != first + 1 && numbers[left] == numbers[left - 1]) left ++;
			while (left < right && right != numbers.length - 1 && numbers[right] == numbers[right + 1]) right --;
			if (left >= right) break;
			
			int sum = numbers[left] + numbers[right];
			if (sum == -numbers[first]) {
				add_solution(numbers[first], numbers[left], numbers[right]);
				left ++;
				right --;
			} else if (sum > -numbers[first]) {
				right --;
			} else {
				left ++;
			}
		}
	}
	
	void add_solution(int a, int b, int c) {
		List<Integer> row = new ArrayList<>();
		row.add(a);
		row.add(b);
		row.add(c);
		ans.add(row);
	}
