// https://leetcode.com/problems/super-ugly-number/


public class Solution {


	private class Factor implements Comparable<Factor> {
		
		int fact;
		int next;
		int index;
		
		public Factor (int fact) {
			this.fact = fact;
			this.next = fact;  // next relative
			this.index = 0;  // last index where relative is derived.
		}
		
		public int compareTo (Factor other) {
			return this.next - other.next;
		}
	}
	
	public int nthSuperUglyNumber (int n, int[] primes) {
		if (n <= 0 || primes == null || primes.length == 0) return -1;
		
		PriorityQueue<Factor> heap = new PriorityQueue<>();
		for (int p : primes) {
			heap.offer(new Factor(p));
		}
		
		int[] nums = new int[n];
		nums[0] = 1;
		int i = 1;
		while (i < n) {
			Factor f = heap.poll();
			if (f.next != nums[i-1]) nums[i++] = f.next;  // avoid duplicates
			// get next relative
			f.index += 1;
			f.next = nums[f.index] * f.fact;
			heap.offer(f);
		}
				
		return nums[n-1];
	}	


}

