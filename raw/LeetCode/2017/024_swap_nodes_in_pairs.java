
	public ListNode swapPairs (ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode p = head;
		while (p != null && p.next != null) {
			ListNode q = p.next;
			ListNode r = q.next;
			prev.next = q;
			q.next = p;
			p.next = r;
			prev = p;
			p = r;
		}
		return dummy.next;
	}
	

	public ListNode swapPairs (ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (head != null && head.next != null) {
			ListNode remaining = head.next.next;
			curr.next = head.next;
			curr = curr.next;
			curr.next = head;
			curr = curr.next;
			head = remaining;
		}
		curr.next = head;
		return dummy.next;
	}
