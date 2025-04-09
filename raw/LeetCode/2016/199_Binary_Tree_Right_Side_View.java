// https://leetcode.com/problems/binary-tree-right-side-view/


public class Solution {


	public List<Integer> rightSideView (TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null) return ans;
		Deque<TreeNode> bfs = new ArrayDeque<>();
		bfs.offerLast(root);
		while (!bfs.isEmpty()) {
			int sz = bfs.size();
			for (int i = 0; i < sz; i++) {
				TreeNode node = bfs.pollFirst();
				if (i == 0) ans.add(node.val);
				if (node.right != null) bfs.offerLast(node.right);
				if (node.left  != null) bfs.offerLast(node.left);
			}
		}
		return ans;
	}	


}

