package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class I0067BinaryTreeInorderTraversal {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
                ans.add(root.val);
                root = root.right;
            }
        }

        return ans;
    }
    
}
