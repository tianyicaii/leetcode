package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class I0480BinaryTreePaths {
    
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        if (root.left == null && root.right == null) {
            ans.add(root.val + "");
            return ans;
        }
        if (root.left != null) {
            List<String> L = binaryTreePaths(root.left);
            for (String l : L) {
                ans.add(root.val + "->" + l);
            }
        }
        if (root.right != null) {
            List<String> R = binaryTreePaths(root.right);
            for (String r : R) {
                ans.add(root.val + "->" + r);
            }
        }
        return ans;
    }


    public List<String> binaryTreePaths_(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> bfs = new LinkedList<>();
        Queue<String> paths = new LinkedList<>();
        
        bfs.add(root);
        paths.add("" + root.val);

        while (!bfs.isEmpty()) {
            TreeNode x = bfs.poll();
            String path = paths.poll();
            if (x.left == null && x.right == null) ans.add(path);
            else {
                if (x.left != null) {
                    bfs.offer(x.left);
                    paths.offer(path + "->" + x.left.val);
                }
                if (x.right != null) {
                    bfs.offer(x.right);
                    paths.offer(path + "->" + x.right.val);
                }
            }
        }
        return ans;
    }
}
