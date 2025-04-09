// https://leetcode.com/problems/count-univalue-subtrees/


public class Solution {


	private class RetVal {
		boolean isUniVal;
		int val;
		int count;
		public RetVal (boolean isUniVal, int val, int count) {
			this.isUniVal = isUniVal;
			this.val = val;
			this.count = count;
		}
	}

	public int countUnivalSubtrees(TreeNode root) {
		if (root == null) return 0;
		return helper(root).count;
	}

	private RetVal helper (TreeNode root) {
		if (root.left == null && root.right == null) return new RetVal(true, root.val, 1);
		RetVal L, R;
		if (root.left  != null) L = helper(root.left);
		else                    L = new RetVal(true, root.val, 0);
		if (root.right != null) R = helper(root.right);
		else                    R = new RetVal(true, root.val, 0);

		if (L.isUniVal == false || R.isUniVal == false) return new RetVal(false, root.val, L.count + R.count);
		if (L.val != root.val   || R.val != root.val)   return new RetVal(false, root.val, L.count + R.count);
		return new RetVal(true, root.val, L.count + R.count + 1);
	}


}

