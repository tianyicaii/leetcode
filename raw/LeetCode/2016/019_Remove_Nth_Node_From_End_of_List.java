// https://leetcode.com/problems/remove-nth-node-from-end-of-list/


public class Solution {


	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;  // in case the head is the one to be removed
		
		ListNode curr = head;
		ListNode prev = dummy;
		
		// curr should lead by n + 1 links
		
		for (int i = 0; i < n; i++) {
			curr = curr.next;
		}
		while (curr != null) {
			prev = prev.next;
			curr = curr.next;
		}
		
		prev.next = prev.next.next;
		return dummy.next;
	}


}

