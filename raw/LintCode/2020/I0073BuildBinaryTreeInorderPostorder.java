package lintcode;

public class I0073BuildBinaryTreeInorderPostorder {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildTree(int[] inorder, int begI, int endI, int[] postorder, int begP, int endP) {
        if (begP == endP) return null;
        int leftSize = countLeftSize(inorder, begI, endI, postorder[endP - 1]);
        TreeNode x = new TreeNode(postorder[endP - 1]);
        x.left = buildTree(inorder, begI, begI + leftSize, postorder, begP, begP + leftSize);
        x.right = buildTree(inorder, begI + leftSize + 1, endI, postorder, begP + leftSize, endP - 1);
        return x;
    }

    private int countLeftSize(int[] A, int beg, int end, int k) {
        for (int i = beg, cnt = 0; i < end; i++, cnt++) {
            if (A[i] == k) return cnt;
        }
        return 0;
    }
}
