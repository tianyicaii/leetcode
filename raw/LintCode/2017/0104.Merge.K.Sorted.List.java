/* 
 *  http://www.lintcode.com/en/problem/merge-k-sorted-lists/
 *
 *  Merge k sorted linked lists and return it as one sorted list.
 *  Analyze and describe its complexity.
 */

// heap
	class ListNodeComparator implements Comparator<ListNode> {
		@Override
		public int compare (ListNode a, ListNode b) {
			return a.val - b.val;
		}
	}
	
	public ListNode mergeKLists (List<ListNode> lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new ListNodeComparator());
		for (ListNode x : lists) {
			if (x != null) pq.offer(x);
		}
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (!pq.isEmpty()) {
			ListNode next = pq.poll();
			curr.next = next;
			curr = curr.next;
			if (next.next != null) pq.offer(next.next);
		}
		return dummy.next;
	}




// bottom-up merge
	public ListNode mergeKLists (List<ListNode> lists) {
		if (lists.size() == 0) return null;

		int numLists = lists.size();
		while (numLists > 1) {
			int left = 0;
			int right = numLists - 1;
			while (left < right) {
				lists.set(left, merge(lists.get(left), lists.get(right)));
				left ++;
				right --;
				numLists -= 1;
			}
		}
		return lists.get(0);
	}
	
	ListNode merge (ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (a != null && b != null) {
			if (a.val <= b.val) {
				curr.next = a;
				a = a.next;
			} else {
				curr.next = b;
				b = b.next;
			}
			curr = curr.next;
		}
		if (a != null) curr.next = a;
		if (b != null) curr.next = b;
		return dummy.next;
	}
