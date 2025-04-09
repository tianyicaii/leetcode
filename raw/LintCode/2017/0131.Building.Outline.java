/*
 *  http://www.lintcode.com/en/problem/building-outline/
 *
 *  Given N buildings in a x-axis，each building is a rectangle and can be represented by a triple (start, end, height)
 *  where start is the start position on x-axis, end is the end position on x-axis and height is the height of the building.
 *  Buildings may overlap if you see them from far away，find the outline of them。
 *  An outline can be represented by a triple, (start, end, height),
 *  where start is the start position on x-axis of the outline, end is the end position on x-axis and height is the height of the outline.
 */


	private enum Type { START, END }

	private class Point implements Comparable<Point> {
		int x;
		int y;
		Type t;
		public Point (int x, int y, Type t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
		public int compareTo (Point other) {
			if (x == other.x) {
				if (y == other.y) {
					if (t == other.t) return 0;
					if (t == Type.START) return -1;
					else return 1;
				} else return other.y - y;
			} else return x - other.x;
		}
	}

	public List<List<Integer>> buildingOutline (int[][] buildings) {
		
		ArrayList<Point> points = new ArrayList<>();
		for (int[] b : buildings) {
			points.add(new Point(b[0], b[2], Type.START));
			points.add(new Point(b[1], b[2], Type.END));
		}
		Collections.sort(points);
		
		List<List<Integer>> ans = new ArrayList<>();
		TreeMap<Integer, Integer> heights = new TreeMap<>();
		Point left = null;
		for (Point p : points) {

			if (heights.isEmpty()) {  // same as left == null
				left = p;
				heights.put(p.y, 1);
			} else {  // already in the sky
				if (p.t == Type.START) {
					if (!heights.containsKey(p.y)) heights.put(p.y, 0);
					heights.put(p.y, heights.get(p.y) + 1);
					if (p.y > left.y) {  // a new height
						List<Integer> seg = new ArrayList<>();
						seg.add(left.x);
						seg.add(p.x);
						seg.add(left.y);
						ans.add(seg);
						left = p;
					}
				} else {  // ending point
					heights.put(p.y, heights.get(p.y) - 1);
					if (heights.get(p.y) == 0) {
						heights.remove(p.y);
						if (left.y == p.y) {
							if (left.x != p.x) {  // multiple building may end at the same place
								List<Integer> seg = new ArrayList<>();
								seg.add(left.x);
								seg.add(p.x);
								seg.add(left.y);
								ans.add(seg);
							}
							if (heights.isEmpty()) left = null;
							else left = new Point(p.x, heights.lastKey(), Type.START);
						}
					}
				}
			}
		}
		
		
		
		return ans;
	}
