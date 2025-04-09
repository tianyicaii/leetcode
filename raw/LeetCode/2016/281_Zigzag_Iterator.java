// https://leetcode.com/problems/zigzag-iterator/


public class ZigzagIterator {
	

	// circular motion, bfs queue.


	Deque<Iterator<Integer>> Q;


	public ZigzagIterator (List<Integer> v1, List<Integer> v2) {
		Q = new ArrayDeque<>();
		if (v1.iterator().hasNext()) Q.offerLast(v1.iterator);
		if (v2.iterator().hasNext()) Q.offerLast(v2.iterator);
	}

	public int next () {
		Iterator<Integer> i = Q.pollFirst();
		int ans = i.next();
		if (i.hasNext())
			Q.offerLast(i);
		return ans;
	}

	public boolean hasNext () {
		return !Q.isEmpty();
	}

}


