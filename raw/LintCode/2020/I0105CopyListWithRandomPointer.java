package lintcode;

public class I0105CopyListWithRandomPointer {
    
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    public RandomListNode copyRandomList(RandomListNode head) {

        head = copyNodes(head);
        copyRandomLink(head);
        return separate(head);
    }

    private RandomListNode separate(RandomListNode head) {
        RandomListNode x = new RandomListNode(0);
        RandomListNode xtail = x;
        RandomListNode y = new RandomListNode(0);
        RandomListNode ytail = y;
        while (head != null) {
            RandomListNode copy = head.next;
            xtail.next = head;
            xtail = xtail.next;
            ytail.next = copy;
            ytail = ytail.next;
            head = copy.next;
        }
        xtail.next = null;
        ytail.next = null;
        return y.next;
    }
    
    private void copyRandomLink(RandomListNode head) {
        while (head != null) {
            RandomListNode copy = head.next;
            RandomListNode rand = head.random;
            if (rand != null) copy.random = rand.next;
            head = copy.next;
        }
    }
    
    private RandomListNode copyNodes(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        while (head != null) {
            RandomListNode copy = new RandomListNode(head.label);
            copy.next = head.next;
            head.next = copy;
            head = copy.next;
        }
        return dummy.next;
    }
}
