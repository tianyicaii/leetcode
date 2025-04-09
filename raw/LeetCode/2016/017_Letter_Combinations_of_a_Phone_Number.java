// https://leetcode.com/problems/letter-combinations-of-a-phone-number/


public class Solution {


	Map<Character, char[]> D2L = new HashMap<Character, char[]>() {{
		put('2', new char[] {'a', 'b', 'c'});
		put('3', new char[] {'d', 'e', 'f'});
		put('4', new char[] {'g', 'h', 'i'});
		put('5', new char[] {'j', 'k', 'l'});
		put('6', new char[] {'m', 'n', 'o'});
		put('7', new char[] {'p', 'q', 'r', 's'});
		put('8', new char[] {'t', 'u', 'v'});
		put('9', new char[] {'w', 'x', 'y', 'z'});
	}};
	
	public List<String> letterCombinations (String digits) {
		
		List<String> ans = new ArrayList<>();
		if (digits.length() == 0) return ans;
		
		Deque<String> bfs = new LinkedList<>();
		bfs.offerLast("");

		
		for (int i = 0; i < digits.length(); i++) {
			int sz = bfs.size();
			for (int j = 0; j < sz; j++) {
				String prefix = bfs.pollFirst();
				for (char c : D2L.get(digits.charAt(i)))
					bfs.offerLast(prefix + c);
			}
		}
		
		while (!bfs.isEmpty()) ans.add(bfs.pollFirst());
		return ans;
	}


}

