// https://leetcode.com/problems/merge-k-sorted-lists/


public class Solution {


	private class ListNodeComparator implements Comparator<ListNode> {
		public int compare (ListNode a, ListNode b) {
			return a.val - b.val;
		}
	}
	

	public ListNode mergeKLists (ListNode[] lists) {
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		
		Queue<ListNode> pq = new PriorityQueue<>(new ListNodeComparator());
		for (ListNode node : lists)
			if (node != null) pq.offer(node);
		
		while (!pq.isEmpty()) {
			ListNode node = pq.poll();
			if (node.next != null)
				pq.offer(node.next);
			prev.next = node;
			prev = node;
		}
		
		return dummy.next;
	}
	

}

