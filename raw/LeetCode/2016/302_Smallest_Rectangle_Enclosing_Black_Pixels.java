// https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/


public class Solution {
	

	// the pixels are *** connected ***
		
	public int minArea (char[][] image, int x, int y) {

		
	// LEFT
		int l = -1;
		int r = y;
		while (l < r - 1) {
			int m = l + (r - l) / 2;
			if (hasDotOnCol(image, m)) r = m;
			else                       l = m;
		}
		int left = r;
		
	// RIGHT
		l = y;
		r = image[0].length;
		while (l < r - 1) {
			int m = l + (r - l) / 2;
			if (hasDotOnCol(image, m)) l = m;
			else                       r = m;
		}
		int right = l;
	
	// TOP
		int t = -1;
		int b = x;
		while (t < b - 1) {
			int m = t + (b - t) / 2;
			if (hasDotOnRow(image, m)) b = m;
			else                       t = m;
		}
		int top = b;
		
	// BOTTOM
		t = x;
		b = image.length;
		while (t < b - 1) {
			int m = t + (b - t) / 2;
			if (hasDotOnRow(image, m)) t = m;
			else                       b = m;
		}
		int bottom = t;
		
		return (right - left + 1) * (bottom - top + 1);
	}
	
	private boolean hasDotOnCol (char[][] image, int c) {
		for (int i = 0; i < image.length; i++) {
			if (image[i][c] == '1') return true;
		}
		return false;
	}
	
	private boolean hasDotOnRow (char[][] image, int r) {
		for (int j = 0; j < image[0].length; j++) {
			if (image[r][j] == '1') return true;
		}
		return false;
	}
	

}

