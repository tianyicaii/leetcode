package lintcode;

import java.util.ArrayList;
import java.util.List;

public class I0066BinaryTreePreorderTraversal {
    
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraversal(ans, root);
        return ans;
    }

    private void preorderTraversal(List<Integer> ans, TreeNode x) {
        if (x == null) return;
        ans.add(x.val);
        preorderTraversal(ans, x.left);
        preorderTraversal(ans, x.right);
    }
}
