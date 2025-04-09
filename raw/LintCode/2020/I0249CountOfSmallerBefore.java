package lintcode;

import java.util.ArrayList;
import java.util.List;

public class I0249CountOfSmallerBefore {

    class TreeNode {
        int start;
        int end;
        int cnt = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    TreeNode root;

    TreeNode buildTree(int start, int end) {
        TreeNode root = new TreeNode(start, end);
        if (start == end) return root;
        int mid = (start + end) / 2;
        root.left = buildTree(start, mid);
        root.right = buildTree(mid + 1, end);
        return root;
    }

    void insert(TreeNode x, int v) {
        x.cnt ++;
        if (x.start == x.end) return;
        int mid = (x.start + x.end) / 2;
        if (v <= mid) insert(x.left, v);
        else insert(x.right, v);
    }

    int queryLess(TreeNode x, int v) {
        if (x.start >= v) return 0;
        if (x.end < v) return x.cnt;
        return queryLess(x.left, v) + queryLess(x.right, v);
    }


    public List<Integer> countOfSmallerNumberII(int[] A) {
        root = buildTree(0, 10000);
        List<Integer> ans = new ArrayList<>();
        for (int i : A) {
            ans.add(queryLess(root, i));
            insert(root, i);
        }
        return ans;
    }
}
