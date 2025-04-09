/*
 *  http://www.lintcode.com/en/problem/convert-binary-search-tree-to-doubly-linked-list/
 *
 *  Convert a binary search tree to doubly linked list with in-order traversal.
 */

	class DoublyList {
		DoublyListNode head;
		DoublyListNode tail;
		public DoublyList () {
			head = new DoublyListNode(0);
			tail = new DoublyListNode(0);
			head.next = tail;
			tail.prev = head;
		}
		public void add (int i) {
			DoublyListNode node = new DoublyListNode(i);
			tail.prev.next = node;
			node.prev = tail.prev;
			node.next = tail;
			tail.prev = node;
		}
	}

	DoublyList l;

// recursion
	public DoublyListNode bstToDoublyList(TreeNode root) {
		l = new DoublyList();
		if (root == null) return null;
		helper(root);
		l.tail.prev.next = null;
		l.head.next.prev = null;
		return l.head.next;
	}
	
	private void helper (TreeNode node) {
		if (node == null) return;
		helper(node.left);
		l.add(node.val);
		helper(node.right);
	}


// in-order traversal
	public DoublyListNode bstToDoublyList(TreeNode root) {
		if (root == null) return null;
		
		l = new DoublyList();
		TreeNode curr = root;
		Stack<TreeNode> s = new Stack<>();
		
		while (curr != null || !s.isEmpty()) {
			if (curr == null) {
				curr = s.pop();
				l.add(curr.val);
				curr = curr.right;
			} else {
				s.push(curr);
				curr = curr.left;
			}
		}
		
		l.tail.prev.next = null;
		l.head.next.prev = null;
		return l.head.next;
	}
