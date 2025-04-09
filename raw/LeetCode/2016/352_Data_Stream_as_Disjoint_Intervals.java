// https://leetcode.com/problems/data-stream-as-disjoint-intervals/


	public class SummaryRanges {

		// search with ordered operation

		TreeMap<Integer, Interval> map;  // use start point as key

		/** Initialize your data structure here. */
		public SummaryRanges() {
			map = new TreeMap<>();
		}
		
		public void addNum(int val) {
			if (map.containsKey(val)) return;  // already included
			Integer left  = map.floorKey(val);
			Integer right = map.ceilingKey(val);
			if (left != null && map.get(left).end >= val) return;  // already included.
			
			if (left != null && right != null && map.get(left).end == val - 1 && map.get(right).start == val + 1) {
				map.get(left).end = map.get(right).end;
				map.remove(right);
			}
			else if (left != null && map.get(left).end == val - 1) {
				map.get(left).end = val;
			}
			else if (right != null && map.get(right).start == val + 1) {
				map.put(val, new Interval(val, map.get(right).end));
				map.remove(right);
			}
			else {
				map.put(val, new Interval(val, val));
			}
		}
		
		public List<Interval> getIntervals() {
			return new ArrayList<>(map.values());
		}


	}
