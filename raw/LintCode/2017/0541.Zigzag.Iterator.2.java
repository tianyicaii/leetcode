/*
 *  http://www.lintcode.com/en/problem/zigzag-iterator-ii/
 *
 *  Follow up Zigzag Iterator: What if you are given k 1d vectors?
 *  How well can your code be extended to such cases?
 *  The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
 *  If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".
 */

// each list follows FIFO order, and circular

	public class ZigzagIterator2 {
		
		Queue<Iterator<Integer>> q;
		
		public ZigzagIterator2(List<List<Integer>> vecs) {
			q = new LinkedList<>();
			for (List<Integer> l : vecs) {
				Iterator<Integer> it = l.iterator();
				if (it.hasNext()) q.offer(it);
			}
		}

		public int next() {
			if (hasNext()) {
				Iterator<Integer> it = q.poll();
				int ans = it.next();
				if (it.hasNext()) q.offer(it);  // if it has more, re-enqueue it.
				return ans;
			} else throw new RuntimeException("empty");
		}

	    public boolean hasNext() {
			return !q.isEmpty();
	    }
	}
