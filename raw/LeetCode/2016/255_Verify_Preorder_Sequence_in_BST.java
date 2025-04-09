// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/


public class Solution {


	public boolean verifyPreorder (int[] preorder) {

		Deque<Integer> stack = new ArrayDeque<>();
		Integer lowerLimit = null;

		for (int i = 0; i < preorder.length; i++) {
			
			if (stack.isEmpty() || preorder[i] < stack.peekLast()) {
				if (lowerLimit != null && preorder[i] <= lowerLimit) return false;
				stack.offerLast(preorder[i]);
			}
			
			else {
				while (!stack.isEmpty() && preorder[i] > stack.peekLast()) {
					lowerLimit = stack.pollLast();
				}
				stack.offerLast(preorder[i]);
			}
		}
		
		return true;
	}


}

