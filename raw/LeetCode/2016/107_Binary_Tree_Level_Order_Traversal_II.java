// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/


public class Solution {
	

	public List<List<Integer>> levelOrderBottom (TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) return ans;
		Deque<TreeNode> bfs = new ArrayDeque<>();
		bfs.offerLast(root);
		
		while (!bfs.isEmpty()) {
			int sz = bfs.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < sz; i++) {
				TreeNode node = bfs.pollFirst();
				level.add(node.val);
				if (node.left != null) bfs.add(node.left);
				if (node.right != null) bfs.add(node.right);
			}
			ans.add(level);
		}
		
		Collections.reverse(ans);
		return ans;
	}	


}

