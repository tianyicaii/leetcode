/*

The structure of Segment Tree is a binary tree which each node has two attributes start and end denote an segment / interval.
start and end are both integers, they should be assigned in following rules:
	The root's start and end is given by build method.
	The left child of node A has start=A.left, end=(A.left + A.right) / 2.
	The right child of node A has start=(A.left + A.right) / 2 + 1, end=A.right.
	if start equals to end, there will be no children for this node.
Implement a build method with a given array,
so that we can create a corresponding segment tree with every node value represent the corresponding interval max value in the array,
return the root of this segment tree.

Clarification
	Segment Tree (a.k.a Interval Tree) is an advanced data structure which can support queries like:
	which of these intervals contain a given point
	which of these points are in a given interval
	See wiki: Segment Tree, Interval Tree

Example
	Given [3,2,1,4]. The segment tree will be:

	                 [0,  3] (max = 4)
	                  /            \
	        [0,  1] (max = 3)     [2, 3]  (max = 4)
	        /        \               /             \
	[0, 0](max = 3)  [1, 1](max = 2)[2, 2](max = 1) [3, 3] (max = 4)

 */

	public class SegmentTreeNode {
		public int start, end, max;
		public SegmentTreeNode left, right;
		public SegmentTreeNode(int start, int end, int max) {
			this.start = start;
			this.end = end;
			this.max = max;
		}
	}

	public SegmentTreeNode build (int[] A) {
		return helper (0, A.length-1, A);
	}
	
	private SegmentTreeNode helper (int left, int right, int[] A) {
		if (left > right) return null;
		if (left == right) return new SegmentTreeNode(left, left, A[left]);
		SegmentTreeNode lc = helper(left, (left + right) / 2, A);
		SegmentTreeNode rc = helper((left + right) / 2 + 1, right, A);
		SegmentTreeNode rt = new SegmentTreeNode(left, right, Math.max(lc.max, rc.max));
		rt.left = lc;
		rt.right = rc;
		return rt;
	}
