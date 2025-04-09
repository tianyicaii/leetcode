// https://leetcode.com/problems/ugly-number-ii/


public class Solution {


	private class Factor {
		int factor;
		int index;
		int candi;
		public Factor (int factor) {
			this.factor = factor;
			this.index = 0;  // last multiplied
			this.candi = factor;
		}
	}
	
	private class FactorComparator implements Comparator<Factor> {
		public int compare (Factor a, Factor b) {
			return a.candi - b.candi;
		}
	}
	
	public int nthUglyNumber(int n) {
	
		List<Integer> prev = new ArrayList<>();
		prev.add(1);
		
		// avoid exponential size heap
		PriorityQueue<Factor> PQ = new PriorityQueue<>(new FactorComparator());
		PQ.offer(new Factor(2));
		PQ.offer(new Factor(3));
		PQ.offer(new Factor(5));
		
		Set<Integer> seen = new HashSet<>();  // avoid duplicates
		
		for (int i = 1; i < n; i++) {
			
			Factor next = PQ.poll();
			
			if (!seen.contains(next.candi)) {
				prev.add(next.candi);
				seen.add(next.candi);
			}
			else 
				i--;
			
			next.index += 1;
			next.candi = prev.get(next.index) * next.factor;
			PQ.offer(next);	
		}
		
		return prev.get(n-1);
	}


}

