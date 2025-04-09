/*
 *  http://www.lintcode.com/en/problem/copy-list-with-random-pointer/
 *
 *  A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *  Return a deep copy of the list.
 */

	public RandomListNode copyRandomList (RandomListNode head) {
		Map<RandomListNode, RandomListNode> clone = new HashMap<>();
		RandomListNode curr = head;
		while (curr != null) {
			clone.put(curr, new RandomListNode(curr.label));  // clone all the vertices
			curr = curr.next;
		}
		curr = head;
		while (curr != null) {  // clone all edges
			clone.get(curr).random = clone.get(curr.random);  //  return null if key is null
			clone.get(curr).next = clone.get(curr.next);
			curr = curr.next;
		}
		return clone.get(head);
	}


// hack
	public RandomListNode copyRandomList (RandomListNode head) {

		RandomListNode curr = head;
		while (curr != null) {  // insert cloned nodes after original one
			RandomListNode next = curr.next;
			curr.next = new RandomListNode(curr.label);
			curr.next.next = next;
			curr = next;
		}
		
		curr = head;
		while (curr != null) {  // copy random pointers
			if (curr.random != null) curr.next.random = curr.random.next;
			curr = curr.next.next;
		}
		
		RandomListNode copy_head = head.next;
		curr = head;
		while (curr != null) {  // split two list
			RandomListNode copy = curr.next;
			curr.next = copy.next;  // copy.next == null at the tail of the list
			copy.next = (curr.next == null) ? null : curr.next.next;
			curr = curr.next;
		}
		return copy_head;
	}
