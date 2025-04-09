// https://leetcode.com/problems/palindrome-linked-list/


public class Solution {


	public boolean isPalindrome (ListNode head) {
		if (head == null || head.next == null) return true;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		/*
		 * - - * - - -
		 * 
		 * - - - * - - - 
		 */
		
		ListNode left = new ListNode(0);
		left.next = head;
		ListNode right = new ListNode(0);
		right.next = slow.next;
		slow.next = null;
		
		ListNode curr = right.next;
		ListNode end = curr;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = right.next;
			right.next = curr;
			curr = next;
		}
		end.next = null;
		
		
		while (left != null && right != null) {
			if (left.val != right.val) return false;
			left = left.next;
			right = right.next;
		}
		return true;
	}


}

