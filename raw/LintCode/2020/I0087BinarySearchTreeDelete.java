package lintcode;

public class I0087BinarySearchTreeDelete {
    
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode removeNode(TreeNode root, int value) {
        if (root == null) return null;
        if (root.val > value) root.left = removeNode(root.left, value);
        else if (root.val < value) root.right = removeNode(root.right, value);
        else {  // delete this node
            if (root.left == null) return root.right;  // delete min
            else if (root.right == null) return root.left;  // delete max
            else {
                TreeNode next = findMin(root.right);
                swap(root, next);
                root.right = deleteMin(root.right);
            }
        }
        return root;
    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    private TreeNode deleteMin(TreeNode root) {  // root not null
        if (root.left == null) return root.right;
        root.left = deleteMin(root.left);
        return root;
    }

    private TreeNode findMin(TreeNode root) {  // root not null
        if (root.left == null) return root;
        return findMin(root.left);
    }

}
