/*
 *  http://www.lintcode.com/en/problem/insert-into-a-cyclic-sorted-list/
 *
 *  Given a node from a cyclic linked list which has been sorted,
 *  write a function to insert a value into the list such that it remains a cyclic sorted list.
 *  The given node can be any single node in the list. Return the inserted new node.
 */

	public ListNode insert (ListNode node, int x) {
		if (node == null) {  //  zero node
			ListNode n = new ListNode(x);
			n.next = n;
			return n;
		}
		
		ListNode prev = node;
		ListNode curr = prev.next;
		
		while (curr != node) {  //  !!! in case all elements are equal, or length of list == 1
			
			if (x == prev.val || x == curr.val) break;       //  glue equal elements together
			if (prev.val < x && x < curr.val) break;         //  x falls into prev and curr
			if (prev.val > curr.val && x < curr.val) break;  //  x is min
			if (prev.val > curr.val && x > prev.val) break;  //  x is max
			
			prev = curr;
			curr = curr.next;
		}
		prev.next = new ListNode(x);
		prev.next.next = curr;
		return node;
	}
