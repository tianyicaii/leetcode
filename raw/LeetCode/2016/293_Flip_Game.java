

public class Solution {
	

	public List<String> generatePossibleNextMoves (String s) {
		List<String> ans = new ArrayList<>();
		for (int i = 0; i + 2 <= s.length(); i++) {
			if (s.substring(i, i + 2).equals("++")) 
				ans.add(s.substring(0, i) + "--" + s.substring(i + 2));
		}
		return ans;
	}


}

