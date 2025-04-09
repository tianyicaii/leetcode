/*
 *  http://www.lintcode.com/en/problem/course-schedule-ii/
 *
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.
 *  Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *  Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *  There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 */


	// i -> j if course i is prerequisite of course j
	public int[] findOrder (int numCourses, int[][] prerequisites) {

		Map<Integer, Integer> inDegree = new HashMap<>();  // node with zero in-degree is the course to take next.
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < numCourses; i++) {
			inDegree.put(i, 0);
			graph.put(i, new ArrayList<>());
		}
		for (int[] p : prerequisites) {  // p: [x, y]: y is prerequisite of x
			inDegree.put(p[0], inDegree.get(p[0]) + 1);
			graph.get(p[1]).add(p[0]);
			
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree.get(i) == 0) q.add(i);  // start from freshman year (zero in-degree)
		}
		
		int[] ans = new int[numCourses];
		int i = 0;
		while (!q.isEmpty()) {
			int c = q.poll();
			ans[i++] = c;
			for (int e : graph.get(c)) {
				inDegree.put(e, inDegree.get(e) - 1);
				if (inDegree.get(e) == 0) q.add(e);
			}
		}

		// may contain cycles
		if (i == numCourses) return ans;
		else return new int[] {};
	}




	// i -> j if course j is prerequisite of course i
	public int[] findOrder (int numCourses, int[][] prerequisites) {

		Map<Integer, Integer> inDegree = new HashMap<>();  // a course with zero in-degree is the one on which noting else depends. (senior courses)
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < numCourses; i++) {
			inDegree.put(i, 0);
			graph.put(i, new ArrayList<>());
		}
		for (int[] p : prerequisites) {  // p: [x, y]: y is prerequisite of x
			inDegree.put(p[1], inDegree.get(p[1]) + 1);
			graph.get(p[0]).add(p[1]);
			
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree.get(i) == 0) q.add(i);  // start from senior year
		}
		
		int[] ans = new int[numCourses];
		int i = numCourses;
		while (!q.isEmpty()) {
			int c = q.poll();
			ans[--i] = c;
			for (int e : graph.get(c)) {
				inDegree.put(e, inDegree.get(e) - 1);
				if (inDegree.get(e) == 0) q.add(e);
			}
		}

		// may contain cycles
		if (i == 0) return ans;
		else return new int[] {};
	}
