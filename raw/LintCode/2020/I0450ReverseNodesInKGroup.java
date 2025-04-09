package lintcode;

public class I0450ReverseNodesInKGroup {
    
    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode curr = dummy;
        while (true) {
            for (int i = 0; i < k && curr != null; i++) curr = curr.next;
            if (curr == null) break;
            tail = curr = reverse(tail, curr);
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode tail, ListNode last) {
        ListNode newLast = tail.next;
        ListNode curr = tail.next;
        tail.next = last.next;
        ListNode end = last.next;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = tail.next;
            tail.next = curr;
            curr = next;
        }
        return newLast;        
    }

}
