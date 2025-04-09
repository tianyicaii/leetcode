/*
 *  http://www.lintcode.com/en/problem/course-schedule/
 *
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.
 *  Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *  Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */


// map, set
	public boolean canFinish (int numCourses, int[][] prerequisites) {
		
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		Map<Integer, Integer> inDegree = new HashMap<>();

		for (int i = 0; i < numCourses; i++) {  // gather all nodes
			graph.put(i, new HashSet<>());
			inDegree.put(i, 0);
		}
		for (int[] e : prerequisites) {  // gather all edges, find in-degree. e:[i, j], i is prerequisite of j
			if (graph.get(e[0]).contains(e[1])) continue;  // input may contain duplicates
			graph.get(e[0]).add(e[1]);
			inDegree.put(e[1], inDegree.get(e[1]) + 1);
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for (Map.Entry<Integer, Integer> e : inDegree.entrySet()) {
			if (e.getValue() == 0) q.offer(e.getKey());
		}

		int count = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			++ count;
			for (int e : graph.get(x)) {
				inDegree.put(e, inDegree.get(e) - 1);
				if (inDegree.get(e) == 0) q.offer(e);
			}
		}
		return count == numCourses;
	}	


// array
	public boolean canFinish (int numCourses, int[][] prerequisites) {
		
		Set<Integer>[] graph = (Set<Integer>[]) new HashSet[numCourses];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new HashSet<Integer>();
		}
		int[] inDegree = new int[numCourses];
		
		for (int[] e : prerequisites) {  // e:[i, j], i is prerequisite of j
			if (graph[e[0]].contains(e[1])) continue;  // input may contain duplicates
			graph[e[0]].add(e[1]);
			++inDegree[e[1]];
		}

		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < inDegree.length; i++)
			if (inDegree[i] == 0) q.offer(i);
	
		int count = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			++ count;
			for (int e : graph[x]) {
				-- inDegree[e];
				if (inDegree[e] == 0) q.offer(e);
			}
		}
		return count == numCourses;
	}	
