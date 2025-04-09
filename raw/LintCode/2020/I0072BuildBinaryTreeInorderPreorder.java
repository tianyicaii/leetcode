package lintcode;

public class I0072BuildBinaryTreeInorderPreorder {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int begP, int endP, int[] inorder, int begI, int endI) {
        if (begP == endP) return null;
        int leftSize = countLeftSize(inorder, begI, endI, preorder[begP]);
        TreeNode x = new TreeNode(preorder[begP]);
        x.left = buildTree(preorder, begP + 1, begP + 1 + leftSize, inorder, begI, begI + leftSize);
        x.right = buildTree(preorder, begP + 1 + leftSize, endP, inorder, begI + leftSize + 1, endI);
        return x;
    }

    private int countLeftSize(int[] A, int beg, int end, int k) {
        for (int i = beg, cnt = 0; i < end; i++, cnt++) {
            if (A[i] == k) return cnt;
        }
        return 0;
    }
}