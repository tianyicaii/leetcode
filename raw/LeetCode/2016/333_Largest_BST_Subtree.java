// https://leetcode.com/submissions/detail/72044606/


public class Solution {


	public class RetVal {
		boolean isValid;
		Integer min;
		Integer max;
		int cnt;
		public RetVal (boolean isValid, Integer min, Integer max, int cnt) {
			this.isValid = isValid;
			this.min = min;
			this.max = max;
			this.cnt = cnt;
		}
	}
	
	public int largestBSTSubtree (TreeNode root) {
		return helper(root).cnt;
	}

	private RetVal helper(TreeNode root) {
		if (root == null) return new RetVal(true, null, null, 0);
		RetVal left = helper(root.left);
		RetVal right = helper(root.right);
		
		
		if (!left.isValid || !right.isValid)  {
			return new RetVal(false, null, null, Math.max(left.cnt, right.cnt));
		}
		
		if (left.max != null && root.val <= left.max ||
			right.min != null && root.val >= right.min) {
			return new RetVal(false, null, null, Math.max(left.cnt, right.cnt));
		}
		

		Integer min = (left.min == null) ? root.val : left.min;
		Integer max = (right.max == null) ? root.val : right.max;
		int cnt = 1 + left.cnt + right.cnt;
		return new RetVal(true, min, max, cnt);
	}	
	
	
}

