package lintcode;

public class I0094BinaryTreeMaxPathSum {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    int max;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        maxThroughRoot(root);
        return max;
    }

    private int maxThroughRoot(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxThroughRoot(root.left));
        int right = Math.max(0, maxThroughRoot(root.right));
        int m = left + root.val + right;
        max = Math.max(max, m);
        return Math.max(left, right) + root.val;
    }
}
