// https://leetcode.com/problems/binary-tree-upside-down/


public class Solution {
	

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null) return root;  // root.right == null
        
        TreeNode newRoot = upsideDownBinaryTree(root);
        root.left.left = root.right;
        root.left.right = root;
        
        root.left = null;  // 
        root.right = null;  //
        
        return newRoot;
    }


}

