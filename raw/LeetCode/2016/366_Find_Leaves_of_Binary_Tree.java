// https://leetcode.com/problems/find-leaves-of-binary-tree/


public class Solution {


	public List<List<Integer>> findLeaves (TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		helper(ans, root);
		return ans;
	}

	// return the height of the subtree
	private int helper (List<List<Integer>> ans, TreeNode root) {
		if (root == null) return -1;
		int left = helper(ans, root.left);
		int right = helper(ans, root.right);
		int height = Math.max(left, right) + 1;
		if (ans.size() == height)
			ans.add(new ArrayList<>());
		ans.get(height).add(root.val);
		return height;
	}


}

