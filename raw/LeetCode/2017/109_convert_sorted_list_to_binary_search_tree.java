
	ListNode list;

	public TreeNode sortedListToBST (ListNode head) {
		int len = length(head);
		list = head;
		return helper(0, len - 1);
	}

	TreeNode helper (int l, int r) {
		if (l > r) return null;
		int mid = l + (r - l) / 2;
		
		TreeNode L = helper(l, mid - 1);
		TreeNode x = new TreeNode(list.val);
		list = list.next;
		TreeNode R = helper(mid + 1, r);
		x.left = L;
		x.right = R;
		return x;
 	}
	
	int length (ListNode head) {
		int ans = 0;
		while (head != null) {
			head = head.next;
			ans += 1;
		}
		return ans;
	}
