// https://leetcode.com/problems/closest-binary-search-tree-value/


public class Solution {
	

	public int closestValue(TreeNode root, double target) {
		if (root == null) throw new IllegalArgumentException("empty tree");
		Integer ceiling = ceiling(root, target);
		Integer floor = floor(root, target);
		
		if (ceiling == null) return floor;
		if (floor == null) return ceiling;
		return (target - floor > ceiling - target) ? ceiling : floor;
	}	
	
	private Integer ceiling (TreeNode root, double target) {
		Integer ans = null;
		while (root != null) {
			if (root.val == target) return root.val;
			if (root.val < target) root = root.right;
			else {
				ans = root.val;  // always decreasing
				root = root.left;
			}
		}
		return ans;
	}
	
	private Integer floor (TreeNode root, double target) {
		Integer ans = null;
		while (root != null) {
			if (root.val == target) return root.val;
			if (root.val > target) root = root.left;
			else {
				ans = root.val;  // always increasing
				root = root.right;
			}
		}
		return ans;
	}


}

