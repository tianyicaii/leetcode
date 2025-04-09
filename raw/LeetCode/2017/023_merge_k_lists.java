
	class ListComparator implements Comparator<ListNode> {
		@Override
		public int compare (ListNode a, ListNode b) {
			return a.val - b.val;
		}
	}
	
	public ListNode mergeKLists (ListNode[] lists) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		ListComparator c = new ListComparator();
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(c);
		for (ListNode l : lists) {
			if (l != null) q.add(l);
		}
		while (!q.isEmpty()) {
			ListNode n = q.poll();
			curr.next = n;
			curr = curr.next;
			if (n.next != null) {
				q.add(n.next);
			}
		}
		return dummy.next;
	}


	public ListNode mergeKLists (ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		int num_of_lists = lists.length;
		while (num_of_lists > 1) {
			int begin = 0;
			int end = num_of_lists - 1;
			while (begin < end) {
				lists[begin] = helper(lists[begin], lists[end]);
				begin ++;
				end --;
				num_of_lists --;
			}
		}
		return lists[0];
	}
	
	public ListNode helper (ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		if (l1 != null) curr.next = l1;
		else if (l2 != null) curr.next = l2;
		else ;
		return dummy.next;
	}
