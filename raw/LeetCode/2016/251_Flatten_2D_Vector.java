// https://leetcode.com/problems/flatten-2d-vector/


	public class Vector2D implements Iterator<Integer> {
		

		Iterator<List<Integer>> row;
		Iterator<Integer> col;
		
		public Vector2D(List<List<Integer>> vec2d) {
			row = vec2d.iterator();
			// cannot initiate col = row.next().iterator(). row might be empty
		}

		public Integer next() {
			if (hasNext())
				return col.next();
			return null;
		}
		
		public boolean hasNext() {
			if (col != null && col.hasNext()) return true;
			while (row.hasNext()) {
				col = row.next().iterator();
				if (col.hasNext()) return true;  // else continue fetching next row
			}
			return false;  // row exhausted
		}


	}

