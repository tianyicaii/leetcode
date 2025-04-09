/*
 *  http://www.lintcode.com/en/problem/search-in-a-big-sorted-array/
 *
 *  Given a big sorted array with positive integers sorted by ascending order.
 *  The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k).
 *  Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.
 *  Return -1, if the number doesn't exist in the array.
 */
	
	public int searchBigSortedArray (ArrayReader reader, int target) {
		if (reader.get(0) > target) return -1;
		if (reader.get(0) == target) return 0;
		int left = 0;
		int right = 1;
		while (reader.get(right) < target) {  // find a range of size <= k where target lands in
			left = right;
			right *= 2;
		}
		while (right - left > 1) {  // invariant: N[left] < target && N[right] >= target
			int mid = left + (right - left) / 2;
			if (reader.get(mid) >= target) right = mid;
			else left = mid;
		}
		if (reader.get(right) == target) return right;
		else return -1;
	}

	class ArrayReader {
		// get the number at index, return -1 if index is less than zero.
		// If you accessed an inaccessible index (outside of the array), ArrayReader.get will return Integer.MAX_VALUE
		public int get (int index) { return 0; }
	}