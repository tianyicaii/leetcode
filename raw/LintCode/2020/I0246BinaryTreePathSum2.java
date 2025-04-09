package lintcode;

import java.util.ArrayList;
import java.util.List;

public class I0246BinaryTreePathSum2 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        if (root == null) return ans;
        helper(new ArrayList<>(), root, target);
        return ans;
    }

    private void helper(List<Integer> path, TreeNode root, int target) {
        path.add(root.val);
        if (target == root.val) {
            ans.add(new ArrayList<>(path));
        }
        if (root.left != null) helper(path, root.left, target-root.val);
        if (root.right != null) helper(path, root.right, target-root.val);
        path.remove(path.size() - 1);
        if (path.isEmpty()) {
            if (root.left != null) helper(path, root.left, target);
            if (root.right != null) helper(path, root.right, target);
        }
    }
}
