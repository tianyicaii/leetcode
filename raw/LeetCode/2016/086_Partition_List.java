// https://leetcode.com/problems/partition-list/


public class Solution {
	

	public ListNode partition (ListNode head, int x) {
		
		ListNode less = new ListNode(0);
		ListNode more = new ListNode(0);
		ListNode lessTail = less;
		ListNode moreTail = more;
		ListNode curr = head;
		
		while (curr != null) {
			if (curr.val < x) {
				lessTail.next = curr;
				lessTail = lessTail.next;
			}
			else {
				moreTail.next = curr;
				moreTail = moreTail.next;
			}
			curr = curr.next;
		}
		lessTail.next = more.next;
		moreTail.next = null;
		return less.next;
	}


}

