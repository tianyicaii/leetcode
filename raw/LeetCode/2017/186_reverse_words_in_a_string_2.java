import java.util.*;

public class Solution {

	public void reverseWords (char[] s) {

		reverse(s, 0, s.length);
		for (int i = 0; i < s.length;) {
			int j = i + 1;
			while (j < s.length && s[j] != ' ') ++j;
			reverse(s, i, j);
			i = j + 1;
		}
	}
	
	public void reverse (char[] s, int begin, int end) {
		--end;
		while (begin < end) {
			char temp = s[begin];
			s[begin] = s[end];
			s[end] = temp;
			++begin;
			--end;
		}
	}

}
