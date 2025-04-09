// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/


public class Solution {


	// level order traversal
	// reverse odd indexed rows
	

	public List<List<Integer>> zigzagLevelOrder (TreeNode root) {
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
				if (node.left  != null) bfs.offerLast(node.left);
				if (node.right != null) bfs.offerLast(node.right);
			}
			ans.add(level);
		}
		
		for (int i = 1; i < ans.size(); i += 2)
			Collections.reverse(ans.get(i));
		
		return ans;
	}


}

