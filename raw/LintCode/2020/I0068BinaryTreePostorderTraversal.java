package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class I0068BinaryTreePostorderTraversal {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    private enum Direction {UP, LEFT, RIGHT};

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Direction> directions = new Stack<>();

        nodes.push(root);
        directions.push(Direction.UP);

        while (!nodes.isEmpty()) {

            TreeNode x = nodes.pop();
            Direction d = directions.pop();

            if (x == null) continue;

            if (d == Direction.UP) {
                nodes.push(x);
                directions.push(Direction.LEFT);
                nodes.push(x.left);
                directions.push(Direction.UP);
            } else if (d == Direction.LEFT) {
                nodes.push(x);
                directions.push(Direction.RIGHT);
                nodes.push(x.right);
                directions.push(Direction.UP);
            } else {
                ans.add(x.val);
            }
        }

        return ans;
    }
}
