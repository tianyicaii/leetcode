// https://leetcode.com/problems/reverse-linked-list/


public class Solution {


	public ListNode reverseList(ListNode head) {
		if (head == null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = dummy.next;
			dummy.next = curr;
			curr = next;
		}
		head.next = null;  // head is not null
		return dummy.next;
	}


    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}

