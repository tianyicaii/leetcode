package lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class I0097BinaryTreeMaxDepth {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth_(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int ans = 0;
        while (!q.isEmpty()) {
            int N = q.size();
            for (int i = 0; i < N; i++) {
                TreeNode x = q.poll();
                if (x.left != null) q.offer(x.left);
                if (x.right != null) q.offer(x.right);
            }
            ans ++;
        }

        return ans;
    }
}
