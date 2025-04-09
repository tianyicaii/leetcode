package lintcode;

public class I0129Rehashing {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode[] rehashing(ListNode[] hashTable) {

        int N = hashTable.length * 2;
        ListNode[] ans = new ListNode[N];

        for (ListNode x : hashTable) {
            while (x != null) {

                int index = x.val % N;
                if (index < 0) index += N;

                if (ans[index] == null) ans[index] = x;
                else {
                    ListNode tail = ans[index];
                    while (tail.next != null) tail = tail.next;
                    tail.next = x;
                }

                ListNode next = x.next;
                x.next = null;
                x = next;
            }
        }

        return ans;
    }
}
