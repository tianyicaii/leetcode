package lintcode;

public class I0439SegmentTree {

    public class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }

    public SegmentTreeNode build(int[] A) {
        if (A.length == 0) return null;
        return build(A, 0, A.length-1);
    }

    private SegmentTreeNode build(int[] A, int l, int r) {
        if (l == r) return new SegmentTreeNode(l, l, A[l]);
        int mid = l + (r - l) / 2;
        SegmentTreeNode left = build(A, l, mid);
        SegmentTreeNode right = build(A, mid+1, r);
        SegmentTreeNode x = new SegmentTreeNode(l, r, Math.max(left.max, right.max));
        x.left = left;
        x.right = right;
        return x;
    }
}
