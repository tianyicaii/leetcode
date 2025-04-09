package lintcode;

public class I0202SegmentTreeQueryMax {
    
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

    public int query(SegmentTreeNode root, int start, int end) {
        if (root.start >= start && root.end <= end) return root.max;
        int mid = (root.start + root.end) / 2;
        if (start > mid) return query(root.right, start, end);
        else if (end <= mid) return query(root.left, start, end);
        else return Math.max(query(root.left, start, mid), query(root.right, mid+1, end));
    }
}
