package lintcode;

public class I0447SearchInBigSortedArray {
    
    class ArrayReader {
		public int get (int index) { return 0; }
	}

    public int searchBigSortedArray(ArrayReader reader, int target) {

        if (reader.get(0) == target) return 0;
        if (reader.get(0) > target) return -1;

        int left = 0;
        int right = 1;

        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) >= target) right = mid;
            else left = mid;
        }

        if (reader.get(right) == target) return right;
        return -1;
    }
}
