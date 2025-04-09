// https://leetcode.com/problems/course-schedule/


public class Solution {


	public boolean canFinish (int numCourses, int[][] prerequisites) {
		
		Map<Integer, List<Integer>> graph = new HashMap<>();  // there might be duolicated edges 1->9, 1->9
		Map<Integer, Integer> inDegree = new HashMap<>();
		
		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new ArrayList<>());
			inDegree.put(i, 0);
		}
		
		for (int[] p : prerequisites) {
			int first = p[1];
			int second = p[0];
			graph.get(first).add(second);
			inDegree.put(second, inDegree.get(second) + 1);  // in-degree += 1;
		}
		
		Deque<Integer> bfs = new ArrayDeque<>();
		for (Map.Entry<Integer, Integer> e : inDegree.entrySet()) {
			if (e.getValue() == 0) bfs.offerLast(e.getKey());  // starting points
		}
		
		while (!bfs.isEmpty()) {
			int curr = bfs.pollFirst();
			for (int next : graph.get(curr)) {
				inDegree.put(next, inDegree.get(next) - 1);  // in-degree -= 1;
				if (inDegree.get(next) == 0) bfs.offerLast(next);
			}
			inDegree.remove(curr);  // or graph.remove(curr);
		}
		
		return inDegree.isEmpty();  // check everything polled.
	}




	public boolean canFinish (int numCourses, int[][] prerequisites) {
		
		Map<Integer, List<Integer>> graph = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		
		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		for (int[] p : prerequisites) {
			int first = p[1];
			int second = p[0];
			graph.get(first).add(second);
		}
		
		for (int i = 0; i < numCourses; i++) {
			if (!visited.contains(i)) 
				if (!dfs(graph, visited, i, new HashSet<>())) return false;
		}
		return true;
	}
	
	private boolean dfs (Map<Integer, List<Integer>> graph, Set<Integer> visited, int index, Set<Integer> onPath) {
		if (onPath.contains(index)) return false;  // cycle detected
		if (visited.contains(index)) return true;  // already checked
		onPath.add(index);
		for (int edge : graph.get(index)) {
			if (!dfs(graph, visited, edge, onPath)) return false;  // cycle detected later
		}
		onPath.remove(index);  // not on path, my reach here from other paths
		visited.add(index);  // this vertex is checked
		return true;  // this vertex is good
	}


}

