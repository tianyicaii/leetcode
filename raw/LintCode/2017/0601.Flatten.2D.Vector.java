/*
 *  http://www.lintcode.com/en/problem/flatten-2d-vector/
 *
 *  Implement an iterator to flatten a 2d vector.
 */

	public class Vector2D implements Iterator<Integer> {

		Iterator<List<Integer>> rowIterator;
		Iterator<Integer> colIterator;
		
		public Vector2D(List<List<Integer>> vec2d) {
			rowIterator = vec2d.iterator();
		}

		@Override
		public Integer next() {
			if (hasNext()) return colIterator.next();
			else return null;
		}

		@Override
		public boolean hasNext() {
			if (colIterator != null && colIterator.hasNext()) return true;  // may not be intialized in the beginning
			while (rowIterator.hasNext()) {
				colIterator = rowIterator.next().iterator();
				if (colIterator.hasNext()) return true;
			}
			return false;
		}

		@Override
		public void remove() {}
	}
