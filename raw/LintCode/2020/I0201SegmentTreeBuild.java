package lintcode;

public class I0201SegmentTreeBuild {
    

    public class SegmentTreeNode {
        public int start, end;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
        }
    }

    public SegmentTreeNode build(int start, int end) {
        if (start > end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        int mid = (start + end) / 2;
        if (start == end) return root;
        root.left = build(start, mid);
        root.right = build(mid+1, end);
        return root;
    }

}
