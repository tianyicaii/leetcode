/*
 *  http://www.lintcode.com/en/problem/kth-largest-in-n-arrays/
 *
 *  Find K-th largest element in N arrays.
 */


	private class Stream implements Comparable<Stream> {
		private int[] array;
		private int index;
		public Stream (int[] a) {
			this.array = a;
			index = a.length - 1;
			Arrays.sort(this.array);
		}
		public boolean hasNext () { return index >= 0; }
		public int next () { return array[index--]; }
		public int compareTo (Stream other) {
			assert this.hasNext() && other.hasNext();
			return other.array[other.index] - this.array[index];
		}
	}

	public int KthInArrays (int[][] arrays, int k) {
		PriorityQueue<Stream> pq = new PriorityQueue<>();
		for (int[] a : arrays) {
			Stream s = new Stream(a);
			if (s.hasNext()) pq.offer(s);
		} 
		
		int i = 1;
		while (!pq.isEmpty()) {
			Stream s = pq.poll();
			int v = s.next();
			if (i++ == k) return v;
			if (s.hasNext()) pq.offer(s);
		}
		
		throw new RuntimeException("invalid k: " + k);
	}
