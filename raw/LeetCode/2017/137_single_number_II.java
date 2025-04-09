
	public int singleNumber (int[] nums) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int x : nums) {
				sum += (x >> i) & 1;
			}
			ans |= (sum % 3) << i;
		}
		return ans;
	}



	public int singleNumber (int[] nums) {
		int once = 0;
		int twice = 0;
		
		
		//  if bit i in once is turned on, then bit i has been seen 3x + i times.
		//  if bit i in twice is turned on, then bit i has been seen 3x + 2 time.
		//  bit i cannot be on in both once and twice.
		//  if bit i has seen 3x + 2 times and we just see it once more
		//  put it in three_strikes and clear it in both once and twice
		
		for (int x : nums) {
			
			twice |= once & x;  //  if seen 3x + 1 times and now again, move it to twice
			once ^= x;  //  turn off bit both in once and x, they have been moved to twice
			
			int three_strikes = once & twice;
			once &= ~three_strikes;
			twice &= ~three_strikes;
		}

	
		return once;
	}
	