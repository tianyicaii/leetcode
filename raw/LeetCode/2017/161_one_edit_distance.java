import java.util.*;

public class Solution {

	public boolean isOneEditDistance (String s, String t) {
		if (Math.abs(s.length() - t.length()) > 1) return false;
		if (s.length() > t.length()) return isOneEditDistance(t, s);

		int i = 0;
		while (i < s.length() && s.charAt(i) == t.charAt(i)) ++i;
		
		if (s.length() == t.length()) {
			if (i == s.length()) {
				return false;
			} else {
				return s.substring(i + 1).equals(t.substring(i+1));
			}
		} else {
			if (i == s.length()) {
				return true;
			} else {
				return s.substring(i).equals(t.substring(i + 1));
			}
		}
	}

}
