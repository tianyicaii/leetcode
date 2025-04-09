/*
 *  http://www.lintcode.com/en/problem/linked-list-cycle/
 *
 *  Given a linked list, determine if it has a cycle in it.
 */

	public boolean hasCycle(ListNode head) {
		if (head == null) return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) return false;
			fast = fast.next.next;
			slow = slow.next;
		}
		return true;
		
	}	
