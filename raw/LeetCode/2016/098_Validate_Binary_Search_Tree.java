// https://leetcode.com/problems/validate-binary-search-tree/


public class Solution {
	

	public boolean isValidBST (TreeNode root) {
		return helper (root, null, null);
	}	
	private boolean helper (TreeNode root, Integer L, Integer R) {
		if (root == null) return true;
		if (L != null && root.val <= L) return false;
		if (R != null && root.val >= R) return false;
		return helper(root.left,  L, root.val) &&
			   helper(root.right, root.val, R);
	}


}

