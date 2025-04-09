// https://leetcode.com/problems/binary-tree-vertical-order-traversal/


public class Solution {


	// bfs for pre-order traversal
	// hashtable to generalize array
	// deque to append on both end, and keep order

	public List<List<Integer>> verticalOrder (TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) return new ArrayList<>();
		
		Map<Integer, List<Integer>> map  = new HashMap<>();
		Deque       <List<Integer>> cols = new ArrayDeque<>();
		Deque<TreeNode>             bfs  = new ArrayDeque<>();
		Deque<Integer>        positions  = new ArrayDeque<>();  // state for bfs
		bfs.offerLast(root);
		positions.offerLast(0);
		
		while (!bfs.isEmpty()) {
			
			TreeNode node = bfs.pollFirst();
			Integer index = positions.pollFirst();
			
			if (map.containsKey(index))  // accumulate
				map.get(index).add(node.val);
			else {  // extend
				List<Integer> col = new ArrayList<>();
				col.add(node.val);
				map.put(index, col);
				if (index < 0) cols.offerFirst(col);
				else           cols.offerLast(col);
			}
			
			if (node.left != null) {
				bfs.offerLast(node.left);
				positions.offerLast(index - 1);
			}
			if (node.right != null) {
				bfs.offerLast(node.right);
				positions.offerLast(index + 1);				
			}
		}
		
		while (!cols.isEmpty()) ans.add(cols.pollFirst());
		return ans;
	}	


}

