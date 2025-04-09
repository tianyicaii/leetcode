// https://leetcode.com/problems/n-queens/


public class Solution {


	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ans = new ArrayList<>();
		List<String> path = new ArrayList<>();
		helper(ans, path, n, 0);
		return ans;
	}
	
	private void helper (List<List<String>> ans, List<String> path, int n, int index) {  // each one handle one row
		if (index == n) {
			ans.add(new ArrayList<String>(path));
			return;
		}
		
		for (int j = 0; j < n; j++) {
			if (isValid(path, n, index, j)) {
				path.add(buildRow(n, j));
				helper(ans, path, n, index + 1);
				path.remove(path.size() - 1);
			}
		}
	}
	
	private boolean isValid (List<String> path, int n, int r, int c) {
		for (int i = 0; i < r; i++) {
			if (path.get(i).charAt(c) == 'Q') return false;
		}
		for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
			if (path.get(i).charAt(j) == 'Q') return false;
		}
		for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
			if (path.get(i).charAt(j) == 'Q') return false;
		}
		return true;
	}
	
	private String buildRow(int n, int c) {
		StringBuilder row = new StringBuilder();
		for (int j = 0; j < n; j++) {
			if (j == c) row.append("Q");
			else        row.append(".");
		}
		return row.toString();
	}


}

