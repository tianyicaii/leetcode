// https://leetcode.com/problems/reverse-nodes-in-k-group/


public class Solution {


	public ListNode reverseKGroup (ListNode head, int k) {
		
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		
		while (getLength(prev.next) >= k) {
			ListNode originalNext = prev.next;
			prev.next = reverse(prev.next, k);
			prev = originalNext;  // now at the end of group.
		}
		
		
		return dummy.next;
	}
	
	private int getLength (ListNode head) {
		int ans = 0;
		while (head != null) {
			ans += 1;
			head = head.next;
		}
		return ans;
	}
	
	private ListNode reverse (ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		ListNode curr = head;
		for (int i = 0; i < k; i++) {

			ListNode next = curr.next;
			curr.next = dummy.next;
			dummy.next = curr;
			curr = next;
			
		}
		head.next = curr;  // now at the end of group, curr is the start of next group
		return dummy.next;
	}
	

}

