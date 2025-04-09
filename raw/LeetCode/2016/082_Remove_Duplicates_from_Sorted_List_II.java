// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/


public class Solution {
	

	public ListNode deleteDuplicates(ListNode head) {
		

		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		ListNode curr = head;
		
		while (curr != null) {
			
			ListNode prob = curr.next;
			while (prob != null && prob.val == curr.val) prob = prob.next;  // skip all equal elements.
			if (prob == curr.next) {
				prev.next = curr;
				prev = prev.next;
			}
			curr = prob;
		}
		
		prev.next = null;
		return dummy.next;
	}	


}

