// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/


public class Solution {
	

	private ListNode readHead;  // read like a tape
	private int getLength (ListNode head) {
		int i = 0;
		while (head != null) {
			i += 1;
			head = head.next;
		}
		return i;
	}
	public TreeNode sortedListToBST (ListNode head) {
		readHead = head;
		return helper(getLength(head));  // traverse list only once
	}
	private TreeNode helper (int length) {
		if (length == 0) return null;
		TreeNode root = new TreeNode(0);
		
		// build left
		root.left = helper(length / 2);
		
		// get root
		root.val = readHead.val;
		readHead = readHead.next;
		
		// build right
		root.right = helper (length - length / 2 - 1);
		return root;
	}


}

