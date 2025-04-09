package lintcode;

public class I0165MergeTwoSortedList {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode move(ListNode dst, ListNode src) {
        dst.next = src.next;
        src.next = src.next.next;
        dst.next.next = null;
        return dst.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode A = new ListNode(0);
        ListNode B = new ListNode(0);
        ListNode C = new ListNode(0);
        A.next = l1;
        B.next = l2; 
        ListNode c = C;

        while (A.next != null && B.next != null) {
            if (A.next.val <= B.next.val) c = move(c, A);
            else c = move(c, B);
        }
        while (A.next != null) c = move(c, A);
        while (B.next != null) c = move(c, B);
        return C.next;
    }
}
