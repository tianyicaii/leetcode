// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/


public class Solution {


	public class RetVal {
		int index;
		boolean isValid;
		public RetVal (int index, boolean isValid) {
			this.index = index;
			this.isValid = isValid;
		}
	}

	public boolean isValidSerialization(String preorder) {
		String[] vals = preorder.split(",");
		RetVal ans = helper(vals, 0);
		return ans.isValid && ans.index == vals.length;
	}
	
	private RetVal helper (String[] preorder, int index) {
		if (index == preorder.length)    return new RetVal(index, false);
		if (preorder[index].equals("#")) return new RetVal(index + 1, true);
		
		RetVal left = helper(preorder, index + 1);
		if (!left.isValid) return left;
		return helper(preorder, left.index);
	}


}

