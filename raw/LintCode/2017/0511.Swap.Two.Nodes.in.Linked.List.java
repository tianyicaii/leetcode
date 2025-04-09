/*
 *  http://www.lintcode.com/en/problem/swap-two-nodes-in-linked-list/#
 *
 *  Given a linked list and two values v1 and v2. Swap the two nodes in the linked list with values v1 and v2.
 *  It's guaranteed there is no duplicate values in the linked list.
 *  If v1 or v2 does not exist in the given linked list, do nothing.
 */


	public ListNode swapNodes (ListNode head, int v1, int v2) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		ListNode p1 = findPred(dummyHead, v1);
		if (p1 == null) return head;
		ListNode p2 = findPred(dummyHead, v2);
		if (p2 == null) return head;
		
		if (p1 == p2.next) {  // ... p2->v2->v1 ...
			ListNode a = p2;
			ListNode b = p2.next;
			ListNode c = p1.next;
			ListNode d = p1.next.next;
			a.next = c;
			c.next = b;
			b.next = d;
		
		} else if (p2 == p1.next) {  // ... p1->v1->v2 ...
			ListNode a = p1;
			ListNode b = p1.next;
			ListNode c = p2.next;
			ListNode d = p2.next.next;
			a.next = c;
			c.next = b;
			b.next = d;
		} else {  //  ... p1->v1 ... p2->v2 ...
			ListNode a = p1;
			ListNode b = p1.next;
			ListNode c = p1.next.next;
			ListNode d = p2;
			ListNode e = p2.next;
			ListNode f = p2.next.next;
			a.next = e;
			e.next = c;
			d.next = b;
			b.next = f;
		}
		
		return dummyHead.next;
	}	

	private ListNode findPred (ListNode head, int v) {
		ListNode prev = head;
		while (prev.next != null) {
			if (prev.next.val == v) return prev;
			prev = prev.next;
		}
		return null;
	} 
