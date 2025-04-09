// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/


public class Solution {
	

	public void connect (TreeLinkNode root) {
		if (root == null) return;
		Deque<TreeLinkNode> bfs = new ArrayDeque<>();
		bfs.offerLast(root);
		while (!bfs.isEmpty()) {
			int sz = bfs.size();
			TreeLinkNode prev = null;
			for (int i = 0; i < sz; i++) {
				TreeLinkNode curr = bfs.pollFirst();
				if (prev != null)
					prev.next = curr;
				prev = curr;
				if (curr.left != null) bfs.offerLast(curr.left);
				if (curr.right != null) bfs.offerLast(curr.right);
			}
		}
	}	


}

