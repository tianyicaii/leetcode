package lintcode;

import java.util.Stack;

public class I0126MaxTree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode maxTree(int[] A) {

        if (A.length == 0) return null;
        Stack<TreeNode> s = new Stack<>();  // Nodes on the stack has no right child.
        for (int i : A) {
            TreeNode x = new TreeNode(i);
            while (!s.isEmpty() && s.peek().val < i) {
                TreeNode l = s.pop();
                l.right = x.left;
                x.left = l;
            }
            s.push(x);
        }

        TreeNode x = s.pop();
        while (!s.isEmpty()) {
            TreeNode l = s.pop();
            l.right = x;
            x = l;
        }
        return x;
    }


}
