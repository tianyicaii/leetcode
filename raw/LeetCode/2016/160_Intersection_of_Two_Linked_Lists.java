// https://leetcode.com/problems/intersection-of-two-linked-lists/


public class Solution {
	

	public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
		
		if (headA == null || headB == null) return null;
				
		ListNode currA = headA;
		ListNode currB = headB;
		
		ListNode endA = null;
		ListNode endB = null;
		
		while (true) {
			
			if (currA == currB) return currA;
			
			if (currA.next == null) {
				if (endB != null && endB != currA) return null;
				endA = currA;
				currA = headB;
			}
			else { currA = currA.next; }
			if (currB.next == null) {
				if (endA != null && endA != currB) return null;
				endB = currB;
				currB = headA;
			}
			else { currB = currB.next; }
			
		}
	}	


}

