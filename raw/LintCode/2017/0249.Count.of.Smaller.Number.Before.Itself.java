/*

Give you an integer array (index from 0 to n-1, where n is the size of this array, data value from 0 to 10000).
For each element A[i] in the array, count the number of element before this element A[i] is smaller than it and return count number array.

Notice
	We suggest you finish problem Segment Tree Build, Segment Tree Query II and Count of Smaller Number first.

Example
	For array [1,2,7,8,5], return [0,1,2,3,2]

*/

public class Solution {
	
	class SegmentTreeNode {
		int start;
		int end;
		int count;
		SegmentTreeNode left;
		SegmentTreeNode right;
		public SegmentTreeNode (int start, int end, int count) {
			this.start = start;
			this.end = end;
			this.count = count;
		} 
	}

	public SegmentTreeNode build (int start, int end) {
		if (start > end) return null;
		SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
		if (start != end) {
			int mid = (start + end) / 2;
			root.left = build(start, mid);
			root.right = build(mid + 1, end);
		}
		return root;
	}


	public int querySegmentTree (SegmentTreeNode root, int start, int end) {
		if (start == root.start && root.end == end) return root.count;
		int mid = (root.start + root.end) / 2;
		int leftCount = 0;
		int rightCount = 0;
		if (start > mid) return querySegmentTree(root.right, start, end);
		if (end <= mid) return querySegmentTree(root.left, start, end);
		return querySegmentTree(root.left, start, mid) + querySegmentTree(root.right, mid + 1, end);
	}

	public void modifySegmentTree (SegmentTreeNode root, int index, int value) {
		if (root.start == index && root.end == index) {
			root.count += value;
			return;
		}
		int mid = (root.start + root.end) / 2;
		if (index <= mid) modifySegmentTree(root.left, index, value);
		if (index > mid) modifySegmentTree(root.right, index, value);
		root.count = root.left.count + root.right.count;
	}

	public List<Integer> countOfSmallerNumberII (int[] A) {
		//
		SegmentTreeNode root = build(0, 10000);
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			int res = (A[i] > 0) ? querySegmentTree(root, 0, A[i] - 1) : 0;
			modifySegmentTree(root, A[i], 1);
			ans.add(res);
		}
		return ans;
	}

}
