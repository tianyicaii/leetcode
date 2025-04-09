// https://leetcode.com/problems/lexicographical-numbers/


public class Solution {


	public List<Integer> lexicalOrder(int n) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i <= 9 && i <= n; i++) {
			ans.add(i);
			traversal(ans, i, n);
		}
		return ans;
	}

	public void traversal (List<Integer> ans, int root, int n) {
		for (int i = 0; i <= 9; i++) {
			int node = root * 10 + i;
			if (node <= n) {
				ans.add(node);
				traversal(ans, node, n);
			}
		}
	}

}

