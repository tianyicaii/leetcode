import java.util.*;

public class Solution {


	public int read (char[] buf, int n) {
		int ret = 0;
		char[] b = new char[4];
		boolean eof = false;
		while (!eof && ret < n) {
			int len = read4(b);
			if (len < 4) eof = true;
			
			int l = Math.min(n - ret, len);
			helper(buf, ret, b, 0, l);
			ret += l;
		}
		return ret;
	}
	
	void helper (char[] dst, int i, char[] src, int j, int len) {
		for (int k = 0; k < len; k ++) {
			dst[i + k] = src[j + k];
		}
	}

}
