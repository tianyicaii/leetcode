// https://leetcode.com/problems/paint-house-ii/


public class Solution {	


	private class Choice {
		int choice;
		int cost;  // cumulative cost
		public Choice (int choice, int cost) {
			this.choice = choice;
			this.cost   = cost;
		}
	}

	private class ChoiceComparator implements Comparator<Choice> {
		public int compare (Choice a, Choice b) {
			return a.cost - b.cost;
		}
	}
	
	public int minCostII (int[][] costs) {
		if (costs == null) throw new IllegalArgumentException("null args");
		if (costs.length == 0) return 0;  // nothing to paint
		int n = costs.length;
		int k = costs[0].length;
		if (k == 1) {
			if (n == 1) return costs[0][0];  // one house
			else        throw new IllegalArgumentException("not enough colors");
		}
		
		// at least two colors
		// initialize at first house, get the best two.
		List<Choice> bestTwo = init(costs);
			
		// DP
		for (int i = 1; i < n; i++)
			bestTwo = getNext(bestTwo, i, costs);
		
		// get minimum at end
		return bestTwo.get(0).cost;
	}
	
	// initialize best two at first house
	private List<Choice> init (int[][] costs) {
		PriorityQueue<Choice> pq = new PriorityQueue<>(new ChoiceComparator());
		for (int j = 0; j < costs[0].length; j++) {
			pq.offer(new Choice(j, costs[0][j]));
		}
		List<Choice> ans = new ArrayList<>();
		ans.add(pq.poll());
		ans.add(pq.poll());
		return ans;
	}
	
	// DP
	private List<Choice> getNext (List<Choice> prev, int i, int[][] costs) {

		PriorityQueue<Choice> pq = new PriorityQueue<>(new ChoiceComparator());
		for (int j = 0; j < costs[0].length; j++) {
			if (j == prev.get(0).choice) pq.offer(new Choice(j, costs[i][j] + prev.get(1).cost));
			else                         pq.offer(new Choice(j, costs[i][j] + prev.get(0).cost));
		}
		List<Choice> ans = new ArrayList<>();
		ans.add(pq.poll());
		ans.add(pq.poll());
		return ans;
	}


}


