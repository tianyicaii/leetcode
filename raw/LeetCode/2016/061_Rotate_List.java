// https://leetcode.com/problems/rotate-list/


public class Solution {


	public ListNode rotateRight (ListNode head, int k) {
		
		if (head == null) return null;
		
		int length = 0;
		ListNode curr = head;
		while (curr != null) {
			length += 1;
			curr = curr.next;
		}
		k = k % length;
		if (k == 0) return head;  // special case!!
		
		
		// there are k nodes one the right half
		// curr should lead prev by k links
		// curr stop at last node
		
		
		
		ListNode prev = head;
		         curr = head;
		         
		for (int i = 0; i < k; i++) {
			curr = curr.next;
		}
		
		while (curr.next != null) {
			curr = curr.next;
			prev = prev.next;
		}
		
		ListNode newHead = prev.next;
		curr.next = head;
		prev.next = null;
		return newHead;
				
	}


}

