package lintcode;

public class I0085BinarySearchTreeInsert {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) return node;
        if (root.val > node.val) root.left = insertNode(root.left, node);
        else root.right = insertNode(root.right, node);
        return root;
    }
}
