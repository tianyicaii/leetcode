// https://leetcode.com/problems/delete-node-in-a-linked-list/


public class Solution {

	
	// node is not the last node


	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}


}

