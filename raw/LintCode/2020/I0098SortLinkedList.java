package lintcode;

public class I0098SortLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }

    ListNode A;
    ListNode B;
    ListNode C;

    public ListNode sortList(ListNode head) {

        A = new ListNode(0);
        B = new ListNode(0);
        C = new ListNode(0);
        C.next = head;

        int N = getLength(head);
        for (int i = 1; i < N; i *= 2) {
            split(i);
            merge(i);
        }

        return C.next;
    }

    private ListNode move(ListNode dst, ListNode src) {
        dst.next = src.next;
        src.next = src.next.next;
        dst.next.next = null;
        return dst.next;
    }

    private boolean isEmpty(ListNode l) {
        return l.next == null;
    }

    private void split(int len) {
        ListNode a = A;
        ListNode b = B;

        while (!isEmpty(C)) {
            for (int i = 0; i < len && !isEmpty(C); i++) a = move(a, C);
            for (int i = 0; i < len && !isEmpty(C); i++) b = move(b, C);
        }
    }

    private void merge(int len) {
        ListNode c = C;

        int cntA = 0;
        int cntB = 0;
        while (!isEmpty(A) && !isEmpty(B)) {
            if (cntA == len && cntB == len) {
                cntA = 0;
                cntB = 0;
            } else if (cntA == len) {
                c = move(c, B);
                cntB ++;
            } else if (cntB == len) {
                c = move(c, A);
                cntA ++;
            } else {
                if (A.next.val <= B.next.val) {
                    c = move(c, A);
                    cntA ++;
                } else {
                    c = move(c, B);
                    cntB ++;
                }
            }
        }

        while (!isEmpty(A)) c = move(c, A);
        while (!isEmpty(B)) c = move(c, B);
    }
}
