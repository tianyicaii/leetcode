/*
 *  http://www.lintcode.com/en/problem/smallest-rectangle-enclosing-black-pixels/
 *
 *  An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 *  The black pixels are *connected*, i.e., there is only one black region.
 *  Pixels are connected horizontally and vertically.
 *  Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 */

	public int minArea (char[][] image, int x, int y) {
		if (image.length == 0 || image[0].length == 0) return 0;
		
		int top = 0;
		int bottom = image.length - 1;
		int left = 0;
		int right = image[0].length - 1;
		
		// find top
		if (isEmptyRow(image, top)) {
			int r = x;  // start at given block dot and jump up
			while (r - top > 1) {
				int mid = top + (r - top) / 2;
				if (isEmptyRow(image, mid)) top = mid;  // if it is empty, nothing above can be connected.
				else r = mid;
			}
			top = r;
		}
		
		// find bottom
		if (isEmptyRow(image, bottom)) {
			int r = x;  // start at given block dot and jump down
			while (bottom - r > 1) {
				int mid = r + (bottom - r) / 2;
				if (isEmptyRow(image, mid)) bottom = mid;
				else r = mid;
			}
			bottom = r;
		}
		
		// find left
		if (isEmptyCol(image, left)) {
			int c = y;  // start at given block dot and jump left
			while (c - left > 1) {
				int mid = left + (c - left) / 2;
				if (isEmptyCol(image, mid)) left = mid;
				else c = mid;
			}
			left = c;
		}
		
		// find bottom
		if (isEmptyCol(image, right)) {
			int c = y;  // start at given block dot and jump right
			while (right - c > 1) {
				int mid = c + (right - c) / 2;
				if (isEmptyCol(image, mid)) right = mid;
				else c = mid;
			}
			right = c;
		}

		// get area
		return (bottom - top + 1) * (right - left + 1);
	}
	
	private boolean isEmptyRow (char[][] image, int x) {
		for (char c : image[x])
			if (c == '1') return false;
		return true;
	}
	
	private boolean isEmptyCol (char[][] image, int y) {
		for (char[] r : image) 
			if (r[y] == '1') return false;
		return true;
	}
