package lintcode;

public class I0475BinaryTreeMaxPath {
    
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int maxPathSum2(TreeNode root) {
        if (root == null) return 0;
        return root.val + Math.max(0, Math.max(maxPathSum2(root.left), maxPathSum2(root.right)));
    }
}
