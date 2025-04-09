// https://leetcode.com/problems/path-sum-ii/


public class Solution {
	

	public List<List<Integer>> pathSum (TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		if (root == null) return ans;
		helper(ans, path, root, sum);
		return ans;
	}
	private void helper (List<List<Integer>> ans, List<Integer> path, TreeNode root, int sum) {

		// add to path
		path.add(root.val);
		sum -= root.val;
		// leaf
		if (root.left == null && root.right == null) {
			if (sum == 0) ans.add(new ArrayList<>(path));
		}
		// try left
		if (root.left != null)
			helper(ans, path, root.left, sum);
		// try right
		if (root.right != null)
			helper(ans, path, root.right, sum);
		// restore
		path.remove(path.size() - 1);
		sum += root.val;
	}


}

