package lintcode;

public class I0247SegmentTreeQueryCount {
    
    public class SegmentTreeNode {
        public int start, end, count;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }

    public int query(SegmentTreeNode root, int start, int end) {
        if (root == null) return 0;
        if (root.start >= start && root.end <= end) return root.count;
        int mid = (root.start + root.end) / 2;
        if (start > mid) return query(root.right, start, end);
        if (end <= mid) return query(root.left, start, end);
        return query(root.left, start, mid) + query(root.right, mid + 1, end);
    }

}
