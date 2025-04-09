package lintcode;

import java.util.Stack;

public class I0086BinaryTreeIterator {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class BSTIterator {

        Stack<TreeNode> s;

        public BSTIterator(TreeNode root) {
            s = new Stack<>();
            pushLeft(root);
        }
    
        public boolean hasNext() {
            return !s.isEmpty();
        }
    
        public TreeNode next() {
            TreeNode x = s.pop();
            TreeNode r = x.right;
            pushLeft(r);
            return x;
        }

        private void pushLeft(TreeNode root) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
        }
    }
}
