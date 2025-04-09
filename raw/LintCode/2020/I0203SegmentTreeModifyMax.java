package lintcode;

public class I0203SegmentTreeModifyMax {
    
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

    public void modify(SegmentTreeNode root, int index, int value) {
        if (root.start == root.end) {
            root.max = value;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (index <= mid) modify(root.left, index, value);
        else modify(root.right, index, value);
        root.max = Math.max(root.left.max, root.right.max);
    }
}
