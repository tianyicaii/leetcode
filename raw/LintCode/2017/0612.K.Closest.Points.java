/*
 *  http://www.lintcode.com/en/problem/k-closest-points/
 *
 *  Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
 *  Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.
 */

	public Point[] kClosest (Point[] points, Point origin, int k) {
		PriorityQueue<Point> pq = new PriorityQueue<>(new InvertedPointComparator(origin));  // maximum PQ
		for (Point p : points) {
			pq.offer(p);
			if (pq.size() > k) pq.poll();  // poll largest one
		}
		Point[] ans = new Point[k];
		for (int i = k-1; i >= 0; i--) {  //  inverted sorted on heap.
			ans[i] = pq.poll();
		}
		return ans;
	}

	private class InvertedPointComparator implements Comparator<Point> {
		Point origin;
		public InvertedPointComparator (Point o) {
			origin = new Point(o.x, o.y);
		}
		int getDistanceFromOriginSquared (Point p) {
			return (p.x - origin.x) * (p.x - origin.x) + (p.y - origin.y) * (p.y - origin.y);
		}
		@Override
		public int compare (Point a, Point b) {
			int A = getDistanceFromOriginSquared(a);
			int B = getDistanceFromOriginSquared(b);
			if (A == B) {
				if (a.x == b.x) return b.x - a.x;
				return b.y - a.y;
			}
			return B - A;
		}
	}
