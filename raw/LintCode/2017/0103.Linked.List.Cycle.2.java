/*
 *  http://www.lintcode.com/en/problem/linked-list-cycle-ii/
 *
 *  Given a linked list, return the node where the cycle begins.
 *  If there is no cycle, return null.
 */

	public ListNode detectCycle (ListNode head) {
		if (head == null || head.next == null) return null;
		ListNode slow = head;
		ListNode fast = head.next;
		
		while (fast.next != null && fast.next.next != null) {
			if (slow == fast) break;
			slow = slow.next;
			fast = fast.next.next;
			
		}
		
		if (slow != fast) return null;
		slow = slow.next;
		fast = head;  // use the relationship between the distance and the length of cycle
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
