// https://leetcode.com/problems/path-sum/


public class Solution {
	

	public boolean hasPathSum (TreeNode root, int sum) {
		if (root == null) return false;
		if (root.left == null && root.right == null) {
			if (root.val == sum) return true;
			else                 return false;
		}
		
		int remaining = sum - root.val;
		return hasPathSum(root.left, remaining) ||
			   hasPathSum(root.right, remaining);
	}	


}

