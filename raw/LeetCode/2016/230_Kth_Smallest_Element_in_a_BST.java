// https://leetcode.com/problems/kth-smallest-element-in-a-bst/


public class Solution {


	public int kthSmallest (TreeNode root, int k) {
		k = k - 1;  // convert to index
		int left = getNumNodes(root.left);
		if (left == k) return root.val;
		if (left <  k) return kthSmallest(root.right, k - left - 1 + 1);  // convert back to 1 based index
		else           return kthSmallest(root.left,  k + 1);
	}
	private int getNumNodes (TreeNode root) {
		if (root == null) return 0;
		int left = getNumNodes(root.left);
		int right = getNumNodes(root.right);
		return left + right + 1;
	}


}

