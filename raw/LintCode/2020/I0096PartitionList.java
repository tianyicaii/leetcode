package lintcode;

public class I0096PartitionList {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {

        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode l = left;
        ListNode r = right;

        while (head != null) {
            if (head.val < x) l = append(l, head);
            else r = append(r, head);
            head = head.next;
        }

        l.next = right.next;
        r.next = null;  // terminate the list !!!
        return left.next;
    }

    private ListNode append(ListNode l, ListNode n) {
        l.next = n;
        return n;
    }
}
