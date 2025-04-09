// https://leetcode.com/problems/add-two-numbers/


public class Solution {


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode ans = new ListNode(0);
		ListNode prev = ans;
		
		int carry = 0;
		while (l1 != null && l2 != null) {
			
			int sum = l1.val + l2.val + carry;
			carry = sum / 10;
			
			prev.next = new ListNode(sum % 10);
			prev = prev.next;
			
			l1 = l1.next;
			l2 = l2.next;
		}
		
		ListNode l = null;
		if (l1 != null) l = l1;
		if (l2 != null) l = l2;
		
		while (l != null) {
			int sum = l.val + carry;
			carry = sum / 10;
			prev.next = new ListNode(sum % 10);
			prev = prev.next;
			l = l.next;
		}
		
		if (carry == 1) prev.next = new ListNode(1);
		
		return ans.next;
	}


}

