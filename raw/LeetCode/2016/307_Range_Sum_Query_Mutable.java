// https://leetcode.com/problems/range-sum-query-mutable/


public class Solution {
	

	public class NumArray {

		TreeNode root;
		
	    public NumArray(int[] nums) {
	    	root = buildTree(nums, 0, nums.length - 1);
	    	initSum(root);
	    }
	    
	    private TreeNode buildTree(int[] nums, int left, int right) {
	    	if (left > right) return null;
	    	int mid = left + (right - left) / 2;
	    	TreeNode root = new TreeNode(nums[mid]);
	    	root.index = mid;
	    	root.left = buildTree(nums, left, mid - 1);
	    	root.right = buildTree(nums, mid + 1, right);
	    	return root;
	    }
	    
	    private void initSum (TreeNode root) {
	    	if (root == null) return;
	    	initSum(root.left);
	    	initSum(root.right);
	    	root.sum = root.val + getSum(root.left) + getSum(root.right);
	    	return;
	    }

	    private int getSum (TreeNode node) {
	    	if (node == null) return 0;
	    	else return node.sum;
	    }
	    
	    void update(int i, int val) {
	    	helper(i, val, root);
	    }
	    void helper(int i, int val, TreeNode node) {
	        if      (node.index == i) node.val = val;
	        else if (node.index >  i) helper(i, val, node.left); 
	        else                      helper(i, val, node.right);
	        node.sum = node.val + getSum(node.left) + getSum(node.right);  // update sum
	    }

	    public int sumRange (int i, int j) {
	    	int lessThanI = getPrevSum(i);
	    	int lessThanJ = getPrevSum(j);
	    	int valJ = getVal(j);
	    	return valJ + lessThanJ - lessThanI;
	    }
	
	    private int getPrevSum (int i) {
	    	TreeNode node = root;
	    	int ans = 0;
	    	while (node.index != i) {
	    		if (node.index > i) node = node.left;
	    		else {  // smaller index
	    			ans += node.val + getSum(node.left);
	    			node = node.right;
	    		}
	    	}
	    	return ans + getSum(node.left);  // don't forget its subtree
	    }
	    
	    private int getVal (int i) {
	    	TreeNode node = root;
	    	while (node.index != i) {
	    		if (node.index > i) node = node.left;
	    		else                node = node.right;
	    	}
	    	return node.val;
	    }	    
	    
	}	


}

