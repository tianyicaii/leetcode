/*
 *  http://www.lintcode.com/en/problem/convert-binary-tree-to-linked-lists-by-depth/
 *
 *  Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
 *  (e.g., if you have a tree with depth D, you'll have D linked lists).
 */

	class SLL {
		ListNode head;
		ListNode tail;
		void add (int i) {
			ListNode x = new ListNode(i);
			if (head == null) {
				head = x;
				tail = x;
			} else {
				tail.next = x;
				tail = x;
			}
		}
	}

	public List<ListNode> binaryTreeToLists (TreeNode root) {
		List<ListNode> ans = new ArrayList<>();
		if (root == null) return ans;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			SLL level = new SLL();
			int sz = q.size();
			for (int i = 0; i < sz; ++i) {
				TreeNode x = q.poll();
				if (x.left != null) q.offer(x.left);
				if (x.right != null) q.offer(x.right);
				level.add(x.val);
			}
			ans.add(level.head);
		}
		return ans;
	}
