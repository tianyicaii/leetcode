// https://leetcode.com/problems/reorder-list/


public class Solution {
	

	public void reorderList (ListNode head) {
		if (head == null || head.next == null) return;  // nothing to do
		ListNode curr = head;
		Deque<ListNode> list = new ArrayDeque<>();
		while (curr != null) {	// add everything to deque
			list.offerLast(curr); 
			curr = curr.next; 
		}
		curr = list.pollFirst();  // head
		while (true) {
			if (list.isEmpty()) break;
			curr.next = list.pollLast();  // from end
			curr = curr.next;
			if (list.isEmpty()) break;
			curr.next = list.pollFirst();  // from start
			curr = curr.next;
		}
		curr.next = null;  // terminate list with null
	}	


}

