// https://leetcode.com/problems/odd-even-linked-list/


public class Solution {


	public ListNode oddEvenList (ListNode head) {
		ListNode odd   = new ListNode(0);
		ListNode even  = new ListNode(0);
		ListNode pOdd  = odd;
		ListNode pEven = even;
		while (true) {
			if (head == null) break;
			pOdd.next = head;
			pOdd = pOdd.next;
			head = head.next;

			if (head == null) break;
			pEven.next = head;
			pEven = pEven.next;
			head = head.next;
		}
		pEven.next = null;  // terminate list.
		pOdd.next = even.next;
		return odd.next;
	}


}

