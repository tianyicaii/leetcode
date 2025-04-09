// https://leetcode.com/problems/course-schedule-ii/


public class Solution {


	public int[] findOrder (int numCourses, int[][] prerequisites) {
		
		Map<Integer, List<Integer>> graph = new HashMap<>();
		Map<Integer, Integer> inDegree = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new ArrayList<>());
			inDegree.put(i, 0);
		}
		for (int[] p : prerequisites) {
			int first = p[1];
			int second = p[0];
			graph.get(first).add(second);
			inDegree.put(second, inDegree.get(second) + 1);
		}
		Deque<Integer> bfs = new ArrayDeque<>();
		for (Map.Entry<Integer, Integer> e : inDegree.entrySet()) {
			if (e.getValue() == 0) bfs.offerLast(e.getKey());
		}
		int[] ans = new int[numCourses];
		int index = 0;
		while (!bfs.isEmpty()) {
			int curr = bfs.pollFirst();
			ans[index ++] = curr;
			for (int next : graph.get(curr)) {
				inDegree.put(next, inDegree.get(next) - 1);
				if (inDegree.get(next) == 0) bfs.offerLast(next);
			}
		}
		if (index != numCourses) return new int[]{};  // not possible
		return ans;
	}


}

