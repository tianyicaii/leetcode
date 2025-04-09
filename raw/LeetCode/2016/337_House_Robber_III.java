// https://leetcode.com/problems/house-robber-iii/


public class Solution {


	Map<TreeNode, Integer> mem = new HashMap<>();

	public int rob(TreeNode root) {
		if (root == null) return 0;
		if (mem.containsKey(root)) return mem.get(root);
		int ans = 0;
		
		// does not rob root
		int left = rob(root.left);
		int right = rob(root.right);
		ans = left + right;	
		
		// rob root
		left = (root.left == null) ? 0 : rob(root.left.left) + rob(root.left.right);
		right = (root.right == null) ? 0 : rob(root.right.left) + rob(root.right.right);
		ans = Math.max(ans, root.val + left + right);
		
		mem.put(root, ans);
		return ans;
	}	



	// [0]: not rob root
	// [1]: may rob root

	public int rob(TreeNode root) {
		int[] ans = helper(root);
		return Math.max(ans[0], ans[1]);
	}	
	
	public int[] helper (TreeNode root) {
		if (root == null) return new int[2];  // {0, 0}
		
		int[] left  = helper(root.left);
		int[] right = helper(root.right);
		
		int[] ans = new int[2];
		ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		ans[1] = root.val + left[0] + right[0];
		
		return ans;
	}


}

