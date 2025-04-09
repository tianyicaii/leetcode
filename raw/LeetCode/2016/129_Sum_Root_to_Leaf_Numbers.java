// https://leetcode.com/problems/sum-root-to-leaf-numbers/


public class Solution {
	

	private class Node {
		int prev;
		TreeNode node;
		public Node (int prev, TreeNode node) {
			this.prev = prev;
			this.node = node;
		}
	}
	
	public int sumNumbers (TreeNode root) {
		int sum = 0;
		if (root == null) return sum;
		Deque<Node> bfs = new ArrayDeque<>();
		bfs.offerLast(new Node(0, root));
		
		while (!bfs.isEmpty()) {
			Node vertex = bfs.pollFirst();
			int curr = vertex.prev * 10 + vertex.node.val;
			if (vertex.node.left == null && vertex.node.right == null) sum += curr;
			else {
				if (vertex.node.left != null) bfs.offerLast(new Node(curr, vertex.node.left));
				if (vertex.node.right != null) bfs.offerLast(new Node(curr, vertex.node.right));
			}
		}
		return sum;
	}	


}

