/*
 *  http://www.lintcode.com/en/problem/max-tree/
 *
 *  Given an integer array with no duplicates.
 *  A max tree building on this array is defined as follow:
 *      The root is the maximum number in the array
 *      The left subtree and right subtree are the max trees of the subarray divided by the root number.
 *      Construct the max tree by the given array.
 */


	// we cannot decide current element until we see a larger one later
	// once we see a current max, then everything we see so far (on its left) is final.
	
	
	public TreeNode maxTree (int[] A) {

		Stack<TreeNode> s = new Stack<>();
		
		for (int i : nums) {
			TreeNode x = new TreeNode(i);


			while (!s.isEmpty() && i > s.peek().val) {  // left child from previous iteration is the right child of new left child
				TreeNode l = s.pop();
				l.right = x.left;
				x.left = l;
			}
			

			s.push(x);
		}
		
		TreeNode x = s.pop();
		while (!s.isEmpty()) {
			TreeNode l = s.pop();
			l.right = x;
			x = l;
		}
		return x;
	}
