package lintcode;

import java.util.Stack;

public class I0453BinaryTreeToLinkedListPreorder {


    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public void flatten_(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode x = stack.pop();
            if (x.right != null) stack.push(x.right);
            if (x.left != null) stack.push(x.left);
            x.left = null;
            if (!stack.isEmpty()) x.right = stack.peek();
        }
    }


    public void flatten(TreeNode root) {
        helper(root);
    }

    public TreeNode helper(TreeNode root) {  // return tail
        if (root == null) return null;
        TreeNode L = helper(root.left);
        TreeNode R = helper(root.right);
        if (L == null && R == null) return root;
        if (L != null && R == null) {
            root.right = root.left;
            root.left = null;
            return L;
        }
        if (L == null && R != null) {
            return R;
        }
        L.right = root.right;
        root.right = root.left;
        root.left = null;
        return R;
    }

}
