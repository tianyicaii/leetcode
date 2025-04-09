// https://leetcode.com/problems/count-complete-tree-nodes/


public class Solution {


	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		if (root.left != null && root.right == null) return 2;
		// both children not null
		
		int LL = getLeftDepth(root.left);		
		int RL = getLeftDepth(root.right);
		
		if (LL == RL)  // left subtree is complete
			return (int)Math.pow(2, LL) + countNodes(root.right);
		else  // right subtree is complete
			return (int)Math.pow(2, RL) + countNodes(root.left);
	}

	private int getLeftDepth (TreeNode root) {
		int ans = 0;
		while (root != null) {
			ans += 1;
			root = root.left;
		}
		return ans;
	}


}

