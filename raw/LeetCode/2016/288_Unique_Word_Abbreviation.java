// https://leetcode.com/problems/unique-word-abbreviation/


public class ValidWordAbbr {
	
	Map<String, String> D;
	
	public ValidWordAbbr (String[] dictionary) {
		D = new HashMap<>();
		for (String word : dictionary) {
			String abbr = getAbbr(word);
			if (D.containsKey(abbr) && !D.get(abbr).equals(word))  // dictionary might contain duplicates
				D.put(abbr, "");
			else
				D.put(abbr, word);
		}
	}	
	
	private String getAbbr (String word) {
		int n = word.length();
		if (n == 0) return "";  // why is there empty string?
		return word.charAt(0) + 
			   ((n > 2) ? (n - 2) + "" : "") + 
			   word.charAt(n - 1);
	}

	public boolean isUnique (String word) {
		String abbr = getAbbr(word);
		if (D.containsKey(abbr)) return D.get(abbr).equals(word);
		else                     return true;
	}
	
}

