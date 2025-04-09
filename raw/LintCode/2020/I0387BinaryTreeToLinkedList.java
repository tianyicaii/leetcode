package lintcode;

import java.util.Stack;

public class I0387BinaryTreeToLinkedList {
    
    public class DoublyListNode {
        int val;
        DoublyListNode next, prev;
        DoublyListNode(int val) {
            this.val = val;
            this.next = this.prev = null;
        }
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class List {
        DoublyListNode head;
        DoublyListNode tail;
        List() { head = null; tail = null; }
        List(int i) {
            head = new DoublyListNode(i);
            tail = head;
        }
        List(DoublyListNode head, DoublyListNode tail) {
            this.head = head;
            this.tail = tail;
        }
        void add(int i) {
            if (head == null) {
                head = new DoublyListNode(i);
                tail = head;
            } else {
                tail.next = new DoublyListNode(i);
                tail.next.prev = tail;
                tail = tail.next;
            }
        }
    }

    private List append(List left, List right) {
        if (left.head == null) return right;
        if (right.head == null) return left;
        left.tail.next = right.head;
        right.head.prev = left.tail;
        return new List(left.head, right.tail);
    }

    private List helper(TreeNode root) {
        if (root == null) return new List();
        return append(append(helper(root.left), new List(root.val)), helper(root.right));
    }

    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) return null;
        return helper(root).head;
    }


    List ans = new List();

    private void goLeft(TreeNode root, Stack<TreeNode> s) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }

    public DoublyListNode bstToDoublyList_(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        goLeft(root, s);
        while (!s.isEmpty()) {
            TreeNode x = s.pop();
            ans.add(x.val);
            goLeft(x.right, s);
        }
        return ans.head;
    }
}
