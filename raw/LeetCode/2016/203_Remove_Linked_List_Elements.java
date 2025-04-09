// https://leetcode.com/problems/remove-linked-list-elements/


public class Solution {


	public ListNode removeElements (ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		while (prev.next != null) {
			if (prev.next.val == val) {
				prev.next = prev.next.next;
			}
			else {
				prev = prev.next;
			}
		}
		return dummy.next;
	}


}

