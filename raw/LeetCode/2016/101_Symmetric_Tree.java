// https://leetcode.com/problems/symmetric-tree/


public class Solution {
	

	public boolean isSymmetric (TreeNode root) {
		
		if (root == null) return true;
		if (root.left == null && root.right == null) return true;
		if (root.left == null || root.right == null) return false;
		
		Deque<TreeNode> L = new ArrayDeque<>();
		Deque<TreeNode> R = new ArrayDeque<>();
		L.offerLast(root.left);
		R.offerLast(root.right);
		
		while (!L.isEmpty() && !R.isEmpty()) {
			int Lsz = L.size();
			int Rsz = R.size();
			if (Lsz != Rsz) return false;
			for (int i = 0; i < Lsz; i++) {
				TreeNode l = L.pollFirst();
				TreeNode r = R.pollFirst();
				
				if (l.val != r.val)                     return false;
				if (l.left  == null && r.right != null) return false;
				if (l.left  != null && r.right == null) return false;
				if (l.right == null && r.left  != null) return false;
				if (l.right != null && r.left  == null) return false;
				
				if (l.left  != null) L.offerLast(l.left);
				if (l.right != null) L.offerLast(l.right);
				if (r.right != null) R.offerLast(r.right);
				if (r.left  != null) R.offerLast(r.left);
				
			}
		}
		
		return L.isEmpty() && R.isEmpty();
	}


}

