// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/


public class Solution {
	
	int max;
	public int longestConsecutive(TreeNode root) {  // global best
		max = 0;
		helper(root);
		return max;
	}

	public int helper (TreeNode root) {  // local best
		if (root == null) return 0;
		int L = helper(root.left);
		int R = helper(root.right);
		int ans = 1;  // at least one node
		if (L != 0 && root.val == root.left.val - 1)  ans = Math.max(ans, L + 1);
		if (R != 0 && root.val == root.right.val - 1) ans = Math.max(ans, R + 1);
		max = Math.max(max, ans);
		return ans;
	}


}


