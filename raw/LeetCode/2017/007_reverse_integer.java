import java.util.*;

public class Solution {

	public int reverse (int x) {
		if (x == Integer.MIN_VALUE) return 0;
		int sign = (x >= 0) ? 1 : -1;
		x = Math.abs(x);
		int ret = 0;
		while (x != 0) {
			int d = x % 10;
			if (ret > Integer.MAX_VALUE / 10) return 0;
			else if (ret == Integer.MAX_VALUE / 10) {
				if (sign == 1) {
					if (d >= 8) return 0;
				} else {
					if (d >= 9) return 0;
				}
			} else {
				;
			}
			ret = ret * 10 + d;
			x /= 10;
		}
		return sign * ret;
	}
}
