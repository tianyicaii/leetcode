/*
 *  http://www.lintcode.com/en/problem/sequence-reconstruction/
 *
 *  Check whether the original sequence org can be *uniquely* reconstructed from the sequences in seqs.
 *  The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4.
 *  Reconstruction means building a shortest common supersequence of the sequences in seqs
 *  (i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
 *  Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
 */

// topological sort

	public boolean sequenceReconstruction (int[] org, int[][] seqs) {
		
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		Map<Integer, Integer> inDegree = new HashMap<>();  // i->j if i is before j in some given sequence 
		
		for (int[] seq : seqs) {  // gather all the nodes
			for (int i = 0; i < seq.length; i++) {
				int x = seq[i];
				if (!graph.containsKey(x)) graph.put(x, new HashSet<>());
				if (!inDegree.containsKey(x)) inDegree.put(x, 0);
			}
		} 
		
		for (int[] seq : seqs) {  // build graph, only need to connect adjacent ones
			for (int i = 0; i < seq.length - 1; i++) {
					int[] e = new int[] { seq[i], seq[i + 1] };
					if (!graph.get(e[0]).contains(e[1])) {
						graph.get(e[0]).add(e[1]);
						inDegree.put(e[1], inDegree.get(e[1]) + 1);	
					}	
				}
			}
		
		Queue<Integer> q = new LinkedList<>();
		for (Map.Entry<Integer, Integer> e : inDegree.entrySet()) {
			if (e.getValue() == 0) q.offer(e.getKey());
		}
		
		if (org.length != graph.size()) return false;
		
		int i = 0;  // try to match each element in given sequence "org"
		while (!q.isEmpty()) {
			if (q.size() > 1) return false;  // to be unique, for each step there can be only one possible choice
			int x = q.poll();
			if (org[i] != x) return false;  // the choice has to match with given sequence "org"
			else ++ i;
			for (int e : graph.get(x)) {
				inDegree.put(e, inDegree.get(e) - 1);  // reduce its neighbor's in-degree
				if (inDegree.get(e) == 0) q.offer(e);
			}
		}
		return i == org.length;
	}
