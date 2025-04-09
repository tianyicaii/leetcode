import java.util.*;

public class Solution {

	class InStringStream {
		String s;
		int i;
		InStringStream (String s) {
			this.s = s;
			i = 0;
		}
		String next () {
			while (i < s.length() && s.charAt(i) == ' ') i++;
			if (i == s.length()) return null;
			int j = i + 1;
			while (j < s.length() && s.charAt(j) != ' ') j++;
			String ans = s.substring(i, j);
			i = j;
			return ans;
		}
	}

	public String reverseWords (String s) {
		Stack<String> ss = new Stack<String>();
		InStringStream in = new InStringStream(s);
		
		while (true) {
			String x = in.next();
			if (x == null) break;
			else ss.push(x);
		}

		StringBuilder ans = new StringBuilder();
		if (ss.isEmpty()) return "";
		else ans.append(ss.pop());
		while (!ss.isEmpty()) {
			ans.append(' ');
			ans.append(ss.pop());
		}
		
		return ans.toString();
	}
	

}
