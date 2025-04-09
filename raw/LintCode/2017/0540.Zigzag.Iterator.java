/*
 *  http://www.lintcode.com/en/problem/zigzag-iterator/
 *
 *  Given two 1d vectors, implement an iterator to return their elements alternately.
 */

	public class ZigzagIterator {

		Queue<Iterator<Integer>> q;
		
		public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
			q = new LinkedList<>();
			Iterator<Integer> it = v1.iterator();
			if (it.hasNext()) q.offer(v1.iterator());
			it = v2.iterator();
			if (it.hasNext()) q.offer(v2.iterator());
		}

		public int next() {
			if (hasNext()) {
				Iterator<Integer> it = q.poll();
				int ans = it.next();
				if (it.hasNext()) q.offer(it);
				return ans;
			} else throw new RuntimeException("empty");
		}

		public boolean hasNext() {
		    return !q.isEmpty();
		}
	}
