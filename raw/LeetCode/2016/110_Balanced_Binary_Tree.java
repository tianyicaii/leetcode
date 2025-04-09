// https://leetcode.com/problems/balanced-binary-tree/


public class Solution {
	

	private class RetVal {
		boolean isValid;
		int depth;
		public RetVal (boolean isValid, int depth) {
			this.isValid = isValid;
			this.depth = depth;
		}
	}
	public boolean isBalanced (TreeNode root) {
		return helper(root).isValid;
	}	
	private RetVal helper (TreeNode root) {
		if (root == null) return new RetVal(true, 0);
		RetVal L = helper(root.left);
		RetVal R = helper(root.right);
		if (!L.isValid || !R.isValid) return new RetVal(false, 0);
		if (Math.abs(L.depth - R.depth) > 1) return new RetVal(false, 0);
		else return new RetVal(true, Math.max(L.depth, R.depth) + 1);
	}


}

