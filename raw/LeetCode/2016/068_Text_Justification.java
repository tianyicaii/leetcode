// https://leetcode.com/problems/text-justification/


public class Solution {
	

	public List<String> fullJustify (String[] words, int maxWidth) {
		
		List<String> ans = new ArrayList<>();
		List<String> line = new ArrayList<>();
		int count = 0;
		int n = words.length;
		int i = 0;
		while (i < n) {
			String word = words[i]; 
			if (line.size() == 0) { line.add(word); count += word.length(); i ++; }  // current line empty
			else if (maxWidth - count > word.length()) { line.add(word); count += word.length() + 1; i++;}  // current line can hold one more
			else {  // current line full
				int numGaps = line.size() - 1;
				if (numGaps == 0) {  // only one word
					StringBuilder row = new StringBuilder();
					row.append(line.get(0));
					for (int s = count; s < maxWidth; s++) row.append(' ');
					ans.add(row.toString());
				}
				else {
					int spaces = maxWidth - count;
					int extraSpace = spaces / numGaps;
					int extraFront = spaces % numGaps;
					StringBuilder row = new StringBuilder();
					row.append(line.get(0));
					for (int j = 1; j < line.size(); j++) {
						row.append(' ');
						if (j <= extraFront) {
							for (int s = 0; s < extraSpace + 1; s++) row.append(' ');
						}
						else {
							for (int s = 0; s < extraSpace; s++) row.append(' ');
						}
						row.append(line.get(j));
					}
					ans.add(row.toString());
				}
				line.clear();  // i does not increase
				count = 0;
			}
		}
		
		// last line
		StringBuilder row = new StringBuilder();
		row.append(line.get(0));
		for (int j = 1; j < line.size(); j++)
			row.append(" " + line.get(j));
		for (int s = 0; s < maxWidth - count; s++)
			row.append(' ');
		ans.add(row.toString());
		
		return ans;
	}	


}

