/*
 *  http://www.lintcode.com/en/problem/sort-colors-ii/
 *
 *  Given an array of n objects with k different colors (numbered from 1 to k),
 *  sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
 */

	// 3-way partition
	public void sortColors2 (int[] colors, int k) {
		sort(colors, 0, colors.length - 1, 1, k);
	}
	
	void sort (int[] colors, int left, int right, int min, int max) {
		if (left >= right) return;
		if (min >= max) return;
		int pivot = (min + max) / 2;
		int l = left - 1;
		int r = right + 1;
		int x = left;
		while (x < r) {
			if (colors[x] == pivot) x ++;
			else if (colors[x] < pivot) swap(colors, ++l, x++);
			else swap(colors, x, --r);
		}
		sort(colors, left, l, min, pivot - 1);
		sort(colors, r, right, pivot + 1, max);
	}
	
	void swap (int[] colors, int l, int r) {
		int tmp = colors[l];
		colors[l] = colors[r];
		colors[r] = tmp;
	}


//  bucket sort?