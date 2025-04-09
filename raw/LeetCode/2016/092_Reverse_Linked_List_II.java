// https://leetcode.com/problems/reverse-linked-list-ii/


public class Solution {
	

	public ListNode reverseBetween (ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = dummy.next;
		ListNode prev = dummy;
		
		int i = 1;
		while (i < m) {
			prev.next = curr;
			prev = prev.next;
			curr = curr.next;
			i++;
		}
		ListNode end = curr;
		while (i <= n) {
			ListNode next = curr.next;
			curr.next = prev.next;
			prev.next = curr;
			curr = next;
			i++;
		}
		end.next = curr;  // end cannot be null.
		
		return dummy.next;
	}	


}

