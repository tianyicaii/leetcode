// https://leetcode.com/problems/insertion-sort-list/


public class Solution {
	

	public ListNode insertionSortList (ListNode head) {
		ListNode dummy = new ListNode(0);
		while (head != null) {
			ListNode prev = dummy;
			while (prev.next != null && prev.next.val <= head.val) {
				prev = prev.next;
			}
			ListNode next = head.next;
			head.next = prev.next;
			prev.next = head;
			head = next;
		}
		return dummy.next;
	}


}

