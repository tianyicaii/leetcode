// https://leetcode.com/problems/remove-duplicates-from-sorted-list/


public class Solution {
	

	public ListNode deleteDuplicates (ListNode head) {
		
		if (head == null) return head;
		
		ListNode prev = head;
		ListNode curr = head.next;
		while (curr != null) {
			if (curr.val != prev.val) {
				prev.next = curr;
				prev = prev.next;
			}
			curr = curr.next;
		}
		
		prev.next = null;
		return head;
	}	


}

