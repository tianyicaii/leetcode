/*
 *  http://www.lintcode.com/en/problem/partition-list/
 *
 *  Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *  You should preserve the original relative order of the nodes in each of the two partitions.
 */

	public ListNode partition (ListNode head, int x) {
		ListNode small = new ListNode(0);
		ListNode large = new ListNode(0);
		ListNode i = small;
		ListNode j = large;
		while (head != null) {
			if (head.val < x) {
				i.next = head;
				i = i.next;
			} else {
				j.next = head;
				j = j.next;
			}
			head = head.next;
		}
		j.next = null;  // !!! terminate list.
		i.next = large.next;
		return small.next;
	}	
