/*
 *  http://www.lintcode.com/en/problem/reverse-nodes-in-k-group/
 *
 *  Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *  If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *  You may not alter the values in the nodes, only nodes itself may be changed.
 *  Only constant memory is allowed.
 */

	public ListNode reverseKGroup (ListNode head, int k) {
		
		//  add dummy_head
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		
		//  add dummy_tail
		ListNode curr = dummyHead;
		while (curr.next != null) curr = curr.next;
		curr.next = new ListNode(0);
		ListNode dummyTail = curr.next;

		
		ListNode start = dummyHead;
		ListNode end = start.next;
		
		while (true) {
			
			int i = 0;  //  number of node after start, before end.
			while (end != dummyTail && i < k) {
				end = end.next;
				++i;
			}
			
			if (i < k) break;  // last partial group remains the same
			
			ListNode resume = start.next;  // will be put to the end of this interval
			reverse(start, end);
			start = resume;  // start is one before end: assert end == start.next;
		}
		
		// remove dummy_tail
		curr = dummyHead;
		while (curr.next != dummyTail) curr = curr.next;
		curr.next = null;

		// remove dummy_head
		return dummyHead.next;
	}
	
	void reverse (ListNode start, ListNode end) {
		//  reverse node after start, before end
		ListNode last = start.next;
		ListNode curr = start.next.next;
		
		while (curr != end) {
			last.next = curr.next;  // the node to poll up front in next iteration
			curr.next = start.next;
			start.next = curr;
			curr = last.next;
		}
	}
