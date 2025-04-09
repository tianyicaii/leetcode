package lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class I0155BinaryTreeMinimumDepth {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public int minDepth_(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            depth += 1;
            int N = q.size();
            for (int i = 0; i < N; i++) {
                TreeNode x = q.poll();
                if (x.left == null && x.right == null) return depth;
                if (x.left != null) q.offer(x.left);
                if (x.right != null) q.offer(x.right);
            }
        }
        throw new IllegalArgumentException();
    }
}
