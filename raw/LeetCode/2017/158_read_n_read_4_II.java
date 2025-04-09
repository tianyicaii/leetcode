import java.util.*;

public class Solution {

	char[] b = new char[4];
	int offset = b.length;
	int remaining = 0;  //  the last read4 might be not able to fill b
	boolean eof = false;
	
	public int read (char[] buf, int n) {
		int ret = 0;
		while (ret < n) {
			if (remaining == 0) {
				if (eof) break;
				else {
					remaining = read4(b);
					if (remaining < 4) eof = true;
					offset = 0;
				}
			}

			int len = Math.min(n - ret, remaining);
			helper(buf, ret, b, offset, len);
			ret += len;
			remaining -= len;
			offset += len;
		}
		return ret;
	}
	
	void helper (char[] dst, int i, char[] src, int j, int len) {
		for (int k = 0; k < len; k ++) {
			dst[i + k] = src[j + k];
		}
	}

}
