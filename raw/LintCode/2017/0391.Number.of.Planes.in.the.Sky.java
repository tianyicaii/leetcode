/*
 *  http://www.lintcode.com/en/problem/number-of-airplanes-in-the-sky/
 *
 *  Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?
 *  Notice
 *      If landing and flying happens at the same time, we consider landing should happen at first.
 */

	private enum Type { START, END }

	private class Point implements Comparable<Point> {
		int x;
		Type t;
		public Point (int x, Type t) {
			this.x = x;
			this.t = t;
		}
		public int compareTo (Point other) {
			if (x == other.x) {
					if (t == other.t) return 0;
					if (t == Type.START) return 1;  // if same time, landing happens first
					else return -1;
			} else return x - other.x;
		}
	}
	
	public int countOfAirplanes (List<Interval> airplanes) {
		ArrayList<Point> points = new ArrayList<>();
		for (Interval i : airplanes) {
			points.add(new Point(i.start, Type.START));
			points.add(new Point(i.end, Type.END));
		}
		Collections.sort(points);
		
		int count = 0;
		int max = 0;
		
		for (Point p : points) {
			if (p.t == Type.START) count += 1;
			else count -= 1;
			max = Math.max(max, count);
		}

		return max;
	}	
