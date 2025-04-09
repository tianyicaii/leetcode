/*
 *  http://www.lintcode.com/en/problem/subtree-with-maximum-average/
 *
 *  Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
 */

	private class SumAndCount {
		int sum;
		int count;
		public SumAndCount (int sum, int count) {
			this.sum = sum;
			this.count = count;
		}
		double getAvg () {
			return (double)sum / count;
		}
	}
	
	TreeNode ans;
	Double max;
	
	public TreeNode findSubtree2 (TreeNode root) {
		if (root == null) return null;
		helper(root);
		return ans;
	}
	
	private SumAndCount helper (TreeNode node) {
		if (node == null) return new SumAndCount(0, 0);
		SumAndCount left = helper(node.left);
		SumAndCount right = helper(node.right);
		SumAndCount ret = new SumAndCount(left.sum + right.sum + node.val, left.count + right.count + 1);
		
		if (max == null || ret.getAvg() > max) {  // keep the max we see so far
			max = ret.getAvg();
			ans = node;
		}
		return ret;
	}
