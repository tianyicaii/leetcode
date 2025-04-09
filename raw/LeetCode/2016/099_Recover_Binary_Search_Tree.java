// https://leetcode.com/problems/recover-binary-search-tree/


public class Solution {
	

	TreeNode prev;
	TreeNode first;
	TreeNode second;
	
	public void recoverTree(TreeNode root) {
		prev   = null;
		first  = null;
		second = null;
		helper(root);
	// exchange. assume always exist inversion
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
		
	}	
	
	// first, have a basic in order traversal
	// use a 'prev' pointer to make the traversal look like on a linked list
	// for first:
	//     if current node is smaller than previous, previous is out of order
	// for second:
	//     if current node is smaller than previous, current node is out of order
	//     this may set the wrong node in the beginning, but will be corrected later.
	
	private void helper (TreeNode curr) {
		if (curr == null) return;
		
		// go left
		helper (curr.left);
		
		
		// @ root
		if (prev != null) {
			if (first == null && curr.val < prev.val) first  = prev;
			if (first != null && curr.val < prev.val) second = curr;
		}
		prev = curr;
		
		// go right
		helper(curr.right);
	}


}

