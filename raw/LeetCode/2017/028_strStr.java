import java.util.*;

public class Solution {


	public int strStr (String haystack, String needle) {
		
		for (int i = 0; i <= haystack.length() - needle.length(); ++i) {
			
			boolean found = true;
			for (int j = 0; j < needle.length(); ++j) {
				if (needle.charAt(j) != haystack.charAt(i + j)) {
					found = false;
					break;
				} else {
					continue;
				}
			}
			if (found) return i;
		}
		return -1;
	}

}
