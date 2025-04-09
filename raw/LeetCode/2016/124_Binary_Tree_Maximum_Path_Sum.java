// https://leetcode.com/problems/binary-tree-maximum-path-sum/


public class Solution {
	

	private class RetVal {
		int localMax;  // max path in my subtree
		int globalMax;  // I am part of larger path involving my parent
		public RetVal (int localMax, int globalMax) {
			this.localMax = localMax;
			this.globalMax = globalMax;
		}
	}
	public int maxPathSum (TreeNode root) {
		// assume root is not null
		return helper(root).localMax;  // entire tree is also the subtree rooted at root.
	}	
	private RetVal helper (TreeNode root) {
		if (root == null) return new RetVal(Integer.MIN_VALUE, Integer.MIN_VALUE);
		RetVal L = helper(root.left);
		RetVal R = helper(root.right);
		
		int l = Math.max(0, L.globalMax);
		int r = Math.max(0, R.globalMax);
		int globalMax = root.val + Math.max(l, r);
		
		int localMax = root.val + l + r;
		localMax = Math.max(Math.max(L.localMax, R.localMax), localMax);
		
		return new RetVal(localMax, globalMax);
	}


}

