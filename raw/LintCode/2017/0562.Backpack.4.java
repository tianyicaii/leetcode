/*

http://www.lintcode.com/en/problem/backpack-iv/

Given n items with size nums[i] which an integer array and all positive numbers, no duplicates.
An integer target denotes the size of a backpack. Find the number of possible fill the backpack.
Each item may be chosen unlimited number of times

*/


	public int backPackIV (int[] nums, int target) {
		

		int[][] mem = new int[nums.length + 1][target + 1];  // number of ways for sub-target j can be achieved for first i items
		for (int i = 0; i <= nums.length; i++) {  // for each item, (0 item have 0 value)
			for (int j = 0; j <= target; j++) {  // for each sub-target
				

				if (i == 0 && j == 0) mem[i][j] = 1;
				else if (i == 0) mem[i][j] = 0;
				else if (j == 0) mem[i][j] = 1;
				else {

					mem[i][j] = mem[i-1][j];  // number of ways without item[i-1]
					int cnt = 1;
					while (nums[i-1] * cnt <= j) {
						mem[i][j] = mem[i][j] + mem[i-1][j - nums[i-1] * cnt];
						cnt += 1;
					}

				}
			}
		}
		
		return mem[nums.length][target];
	}
