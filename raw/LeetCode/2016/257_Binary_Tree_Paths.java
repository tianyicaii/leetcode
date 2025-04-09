
// https://leetcode.com/problems/binary-tree-paths/


public class Solution {


	public List<String> binaryTreePaths(TreeNode root) {

		List<String> ans = new ArrayList<>();
		if (root == null) return ans;
	
		Deque<TreeNode> bfs = new ArrayDeque<>();
		Deque<String> path =  new ArrayDeque<>();
		bfs.offerLast(root);
		path.offerLast(root.val + "");
	
		while (!bfs.isEmpty()) {

			int sz = bfs.size();
			for (int i = 0; i < sz; i++) {

				TreeNode node = bfs.pollFirst();
				String prefix = path.pollFirst();

				if (node.left == null && node.right == null) {
					ans.add(prefix);
				}
				if (node.left != null) {
					bfs.offerLast(node.left);
					path.offerLast(prefix + "->" + node.left.val);
				}
				if (node.right != null) {
					bfs.offerLast(node.right);
					path.offerLast(prefix + "->" + node.right.val);
				}
			}
		} 

		return ans;
	}


}

