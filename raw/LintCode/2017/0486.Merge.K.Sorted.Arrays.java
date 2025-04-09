/*
 *  http://www.lintcode.com/en/problem/merge-k-sorted-arrays/
 *
 *  Given k sorted integer arrays, merge them into one sorted array.
 */

	public int[] mergekSortedArrays (int[][] arrays) {
		
		PriorityQueue<Stream> pq = new PriorityQueue<>();
		int size = 0;
		for (int[] a : arrays) {
			Stream s = new Stream(a);
			if (s.hasNext()) pq.offer(new Stream(a));
			size += a.length;
		}
		
		int[] ans = new int[size];
		int i = 0;
		while (!pq.isEmpty()) {
			Stream s = pq.poll();
			ans[i++] = s.next();
			if (s.hasNext()) pq.offer(s);
		}
		
		return ans;
	}

    private class Stream implements Comparable<Stream> {
		int[] A;
		int i;
		public Stream (int[] A) {
			this.A = A;
			i = 0;
		}
		public boolean hasNext () {
			if (i < A.length) return true;
			return false;
		}
		public int next () {
			if (!hasNext()) throw new RuntimeException("empty stream");
			return A[i++];
		}
		public int peek () {
			if (!hasNext()) throw new RuntimeException("empty stream");
			return A[i];
		}
		public int compareTo (Stream other) {
			return this.peek() - other.peek();
		}
    }
