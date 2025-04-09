/*
 *  http://www.lintcode.com/en/problem/ugly-number-ii/
 *
 *  Ugly number is a number that only have factors 2, 3 and 5.
 *  Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 */

	public int nthUglyNumber (int n) {

		PriorityQueue<Long> pq = new PriorityQueue<>();
		Set<Long> seen = new HashSet<>();
		int[] factors = new int[] {2, 3, 5}; 
		pq.offer((long)1);
		seen.add((long)1);
		
		for (int i = 1; i < n; i++) {
			long x = pq.poll();
			for (int f : factors) {
				long r = x * f;
				if (!seen.contains(r)) {
					pq.offer(r);
					seen.add(r);
				}
			}
		}
		
		long ans = pq.poll();
		return (int) ans;
	}


// generate in order
	public int nthUglyNumber (int n) {
		
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		int by2 = 0;
		int by3 = 0;
		int by5 = 0;
		
		for (int i = 1; i < n; i++) {
			int last = nums.get(nums.size() - 1);
			while (nums.get(by2) * 2 <= last) by2++;
			while (nums.get(by3) * 3 <= last) by3++;
			while (nums.get(by5) * 5 <= last) by5++;
			nums.add(Math.min(Math.min(nums.get(by2) * 2, nums.get(by3) * 3), nums.get(by5) * 5));
		}

		return nums.get(n - 1);
	}
