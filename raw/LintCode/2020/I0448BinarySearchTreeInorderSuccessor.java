package lintcode;

public class I0448BinarySearchTreeInorderSuccessor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode inorderSuccessor_(TreeNode root, TreeNode p) {

        TreeNode prev = null;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.val == p.val) break;
            else if (curr.val < p.val) curr = curr.right;
            else { prev = curr; curr = curr.left; }
        }

        if (curr == null) return null;  // not found
        if (curr.right != null) {
            curr = curr.right;
            while (curr != null) {
                prev = curr;
                curr = curr.left;
            }
        }

        return prev;
    }


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) return inorderSuccessor(root.right, p);
        TreeNode L = inorderSuccessor(root.left, p);
        if (L != null) return L;
        return root;
    }
}
