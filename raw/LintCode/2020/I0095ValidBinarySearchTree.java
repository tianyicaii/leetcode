package lintcode;

public class I0095ValidBinarySearchTree {
    
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false; 
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    Integer prev;
    public boolean isValidBST_(TreeNode root) {
        prev = null;
        return traversal(root);
    }

    private boolean traversal(TreeNode root) {
        if (root == null) return true;
        if (!traversal(root.left)) return false;
        if (prev != null && root.val <= prev) return false;
        prev = root.val;
        return traversal(root.right);
    }
}
