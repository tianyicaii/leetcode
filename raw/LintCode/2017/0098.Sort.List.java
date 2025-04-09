/*
 *  http://www.lintcode.com/en/problem/sort-list/
 *
 *  Sort a linked list in O(n log n) time using constant space complexity.
 */

// external merge sort

	ListNode left;
	ListNode right;
	ListNode ans;
	
	public ListNode sortList (ListNode head) {

		int totalLength = getLength(head);
		int intervalLength = 1;
		ans = head;
		
		while (intervalLength < totalLength) {
			split(intervalLength);
			merge(intervalLength);
			intervalLength *= 2;
		}
		return ans;
	}
	
	int getLength (ListNode head) {
		int length = 0;
		for (; head != null; head = head.next, ++length);
		return length;
	}
	
	void merge (int length) {
		ans = new ListNode(0);
		ListNode curr = ans;
		int countLeft = 0;
		int countRight = 0;
		
		while (left != null && right != null) {
			
			if (countLeft == length && countRight == length) {  // merge next pair of sublist
				countLeft = 0;
				countRight = 0;
			} else if (countLeft == length) {  // exhaust left sublist
				curr.next = right;
				right = right.next;
				countRight ++;
				curr = curr.next;
			} else if (countRight == length) {  // exhaust right sublist
				curr.next = left;
				left = left.next;
				countLeft ++;
				curr = curr.next;
			} else {  // get smaller one from left and right
				if (left.val <= right.val) {
					curr.next = left;
					left = left.next;
					countLeft ++;
				} else {
					curr.next = right;
					right = right.next;
					countRight ++;
				}
				curr = curr.next;
			}
		}
		if (left != null) curr.next = left;  // link remaining nodes
		if (right != null) curr.next = right;	
		ans = ans.next;  // remove dummy head
	}
	
	void split (int length) {
		left = new ListNode(0);
		right = new ListNode(0);
		ListNode l = left;
		ListNode r = right;

		while (ans != null) {  // split
			for (int i = 0; i < length && ans != null; i++, ans = ans.next) {
				l.next = ans;
				l = l.next;
			}
			for (int i = 0; i < length && ans != null; i++, ans = ans.next) {
				r.next = ans;
				r = r.next;
			}
		}

		l.next = null;  // terminate list
		r.next = null;
		left = left.next;  // remove dummy heads
		right = right.next;
	}



