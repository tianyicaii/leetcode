package lintcode;

public class I0511SwapTwoLinkedListNode {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p1 = findPrev(dummy, v1);
        ListNode p2 = findPrev(dummy, v2);
        if (p1 == null || p2 == null) return dummy.next;
        if (p1.next.next != null && p1.next.next.val == p2.next.val) swapAdjacent(p1);
        else if (p2.next.next != null && p2.next.next.val == p1.next.val) swapAdjacent(p2);
        else swapNonAdjacent(p1, p2);
        return dummy.next;
    }

    private ListNode findPrev(ListNode dummy, int v) {
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == v) return curr;
            curr = curr.next;
        }
        return null;
    }

    private void swapAdjacent(ListNode prev) {
        ListNode a = prev.next;
        ListNode b = a.next;
        ListNode t = b.next;
        prev.next = b;
        b.next = a;
        a.next = t;
    }

    private void swapNonAdjacent(ListNode prev1, ListNode prev2) {
        ListNode a = prev1.next;
        ListNode b = prev2.next;
        ListNode ta = a.next;
        ListNode tb = b.next;
        prev1.next = b;
        b.next = ta;
        prev2.next = a;
        a.next = tb;
    }
}
