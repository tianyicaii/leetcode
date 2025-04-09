// https://leetcode.com/problems/plus-one-linked-list/


public class Solution {


	public ListNode plusOne (ListNode head) {
		head = reverse(head);
		helper(head);
		return reverse(head);
	}

	public ListNode reverse (ListNode head) {
		if (head == null) return null;
		ListNode dummy = new ListNode(0);
		ListNode prev  = dummy;
		ListNode end   = head;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev.next;
			prev.next = head;
			head = next;
		}
		end.next = null;
		return dummy.next;
	}

// add one
	public void helper (ListNode head) {
		if (head == null) return;
		int carry = 1;
		ListNode curr = head;
		while (curr.next != null && carry == 1) {
			int sum = curr.val + carry;
			curr.val = sum % 10;
			carry = sum / 10;
			curr = curr.next;
		}
		if (carry == 1) {
			// curr is pointing to tail
			if (curr.val < 9)
				curr.val += 1;
			else {
				curr.val = 0;
				curr.next = new ListNode(1);
			}
		}
	}

}

