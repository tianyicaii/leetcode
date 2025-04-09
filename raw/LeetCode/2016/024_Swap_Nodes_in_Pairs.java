// https://leetcode.com/problems/swap-nodes-in-pairs/


public class Solution {


	public ListNode swapPairs (ListNode head) {
		

		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		
		while (prev.next != null && prev.next.next != null) {
			
			ListNode x = prev.next;
			ListNode y =    x.next;
			
			x.next = y.next;
			y.next = x;
			prev.next = y;
			
			prev = x;
		}
		
		return dummy.next;
	}


}

