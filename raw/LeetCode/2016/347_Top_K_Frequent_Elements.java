// https://leetcode.com/problems/top-k-frequent-elements/


public class Solution {


	private class Counter {
		int val;
		int cnt;
		public Counter (int val, int cnt) {
			this.val = val;
			this.cnt = cnt;
		}
	}
	
	private class CounterComparatorDecreasing implements Comparator<Counter> {
		public int compare (Counter a, Counter b) {
			return a.cnt - b.cnt;
		}
	}
	
	public List<Integer> topKFrequent (int[] nums, int k) {
		Map<Integer, Integer> counts = new HashMap<>();
		for (int i : nums) {
			counts.put(i, 0);
		}
		for (int i : nums) {
			counts.put(i, counts.get(i) + 1);
		}
	
		PriorityQueue<Counter> topK = new PriorityQueue<>(k + 1, new CounterComparatorDecreasing());
		for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
			topK.offer(new Counter(e.getKey(), e.getValue()));
			if (topK.size() == k + 1)
				topK.poll();
		}
		
		List<Integer> ans = new ArrayList<>();
		while (!topK.isEmpty()) {
			ans.add(topK.poll().val);
		}
		
		Collections.reverse(ans);
		return ans;
	}


}

