// https://leetcode.com/problems/unique-binary-search-trees-ii/


public class Solution {
	

	public List<TreeNode> generateTrees (int n) {
		
		if (n == 0) return new ArrayList<>();
		List<TreeNode>[][] dp = (List<TreeNode>[][]) new List[n + 1][n + 1];  // size of tree, starting value
		
		List<TreeNode> emptyTree = new ArrayList<>();
		emptyTree.add(null);
		
		for (int i = 1; i <= n; i++) {  // size of tree
			for (int j = 1; j + i <= n + 1; j++) {  // starting value
				
				dp[i][j] = new ArrayList<>();
				
				if (i == 1) {
					dp[i][j].add(new TreeNode(j));  // leaves
				}
				
				else {
					for (int k = j; k < j + i; k++) {  // root of subtree
						
						List<TreeNode> L = emptyTree;
						List<TreeNode> R = emptyTree;
						
						if (k > j)
							L = dp[k - j][j];
						if (k < j + i - 1)
							R = dp[i - (k - j + 1)][k + 1];
						
						for (TreeNode l : L) {
							for (TreeNode r : R) {
								TreeNode root = new TreeNode(k);
								root.left  = l;
								root.right = r;
								dp[i][j].add(root);
							}
						}
						
					}
				}
			}
		}
		
		return dp[n][1];
	}


}


emilyrabbit@126.com
19890618Ryh