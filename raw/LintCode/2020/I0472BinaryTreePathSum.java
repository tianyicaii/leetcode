package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class I0472BinaryTreePathSum {
    
    class ParentTreeNode {
        public int val;
        public ParentTreeNode parent, left, right;
    }

    List<List<Integer>> ans;
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<ParentTreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            ParentTreeNode x = s.pop();
            if (x.right != null) s.push(x.right);
            if (x.left != null) s.push(x.left);
            dfs(new ArrayList<>(), x, target, null);
        }
        return ans;
    }

    void dfs(List<Integer> path, ParentTreeNode x, int target, ParentTreeNode prev) {
        path.add(x.val);
        target -= x.val;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
        }
        if (x.parent != null && x.parent != prev) dfs(path, x.parent, target, x);
        if (x.left != null && x.left != prev) dfs(path, x.left, target, x);
        if (x.right != null && x.right != prev) dfs(path, x.right, target, x);
        path.remove(path.size()-1);
    }

}
