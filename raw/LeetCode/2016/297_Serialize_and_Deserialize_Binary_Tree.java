// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/


public class Codec {
	

	public String serialize (TreeNode root) {
		if (root == null) return "#";

		Deque<TreeNode> bfs = new ArrayDeque<>();
		bfs.offerLast(root);
		StringBuilder ans = new StringBuilder();
		ans.append(root.val).append(" ");
		
		while (!bfs.isEmpty()) {
			TreeNode node = bfs.pollFirst();
			if (node.left != null) {
				ans.append(node.left.val).append(" "); 
				bfs.offerLast(node.left);
			}
			else
				ans.append("#").append(" ");
			if (node.right != null) {
				ans.append(node.right.val).append(" "); 
				bfs.offerLast(node.right);
			}
			else
				ans.append("#").append(" ");
		}
		return ans.toString();
	}

	public TreeNode deserialize (String data) {
		if (data.equals("#")) return null;

		String[] vals = data.split("\\s+");
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		Deque<TreeNode> bfs = new ArrayDeque<>();
		bfs.offerLast(root);

		int i = 1;
		while (!bfs.isEmpty()) {
			TreeNode node = bfs.pollFirst();
			if (!vals[i].equals("#")) {
				node.left = new TreeNode(Integer.parseInt(vals[i]));
				bfs.offerLast(node.left);
				i += 1;
			}
			else {
				i += 1;
			}
			if (!vals[i].equals("#")) {
				node.right = new TreeNode(Integer.parseInt(vals[i]));
				bfs.offerLast(node.right);
				i += 1;
			}
			else {
				i += 1;
			}
		}

		return root;
	}


// DFS, preorder


	public String serialize (TreeNode root) {
		StringBuilder ans = new StringBuilder();
		encode(root, ans);
		return ans.toString();
	}
	private void encode (TreeNode root, StringBuilder ans) {
		if (root == null) {
			ans.append("#").append(" ");
			return;
		}
		ans.append(root.val).append(" ");
		encode(root.left, ans);
		encode(root.right, ans);
	}

	public TreeNode deserialize (String data) {
		Deque<String> vals = new ArrayDeque<>();
		vals.addAll(Arrays.asList(data.split("\\s+")));
		return decode(vals);
	}
	private TreeNode decode (Deque<String> vals) {
		String val = vals.pollFirst();
		if (val.equals("#")) return null;
		TreeNode root = new TreeNode(Integer.parseInt(val));
		root.left = decode(vals);
		root.right = decode(vals);
		return root;
	}


}

