// https://leetcode.com/problems/linked-list-cycle-ii/


public class Solution {
	

	public ListNode detectCycle(ListNode head) {
		if (head == null) return null;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			if (slow == fast) break;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast == null || fast.next == null) return null;
		
		fast = fast.next;
		slow = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}	


}

