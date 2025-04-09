package lintcode;

import java.util.ArrayList;
import java.util.List;

public class I0376BinaryTreePathSum {
    
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        if (root == null) return ans;
        binaryTreePathSum(new ArrayList<Integer>(), root, target);
        return ans;
    }

    private void binaryTreePathSum(ArrayList<Integer> path, TreeNode root, int target) {
        path.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) ans.add(new ArrayList<>(path));
        if (root.left != null) binaryTreePathSum(path, root.left, target);
        if (root.right != null) binaryTreePathSum(path, root.right, target);
        path.remove(path.size()-1);
    }
}
