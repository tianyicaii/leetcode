/*
 *  http://www.lintcode.com/en/problem/high-five/
 *
 *  There are two properties in the node student id and scores, each student will have at least 5 points,
 *  find the average of 5 highest scores for each person.
 */

	public Map<Integer, Double> highFive (Record[] results) {

		int count = 5;

		Map<Integer, PriorityQueue<Integer>> highestFive = new HashMap<>();  // minimum PQ
		for (Record r : results) {
			if (!highestFive.containsKey(r.id)) highestFive.put(r.id, new PriorityQueue<Integer>());
			highestFive.get(r.id).offer(r.score);
			if (highestFive.get(r.id).size() == count + 1) highestFive.get(r.id).poll();  // discard minimum
		}
		
		Map<Integer, Double> ans = new HashMap<>();
		for (Map.Entry<Integer, PriorityQueue<Integer>> e : highestFive.entrySet()) {
			double sum = 0;
			int cnt = 0;
			for (int i : e.getValue()) {  // find avg
				sum += i;
			}
			ans.put(e.getKey(), sum / count);
		}
		return ans;
	}
