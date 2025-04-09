package lintcode;


/*

    描述
    给定一个二叉查找树和范围[k1, k2]。按照升序返回给定范围内的节点值。

    您在真实的面试中是否遇到过这个题？  
    样例
    样例 1:

    输入：{5},6,10
    输出：[]
            5
    它将被序列化为 {5}
    没有数字介于6和10之间
    样例 2:

    输入：{20,8,22,4,12},10,22
    输出：[12,20,22]
    解释：
            20
        /  \
        8   22
        / \
        4   12
    它将被序列化为 {20,8,22,4,12}
    [12,20,22]介于10和22之间

*/


import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class I0011BinarySearchTreeRange {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> ans = new ArrayList<>();
        inorder(ans, root, k1, k2);
        return ans;
    }

    private void inorder(List<Integer> ans, TreeNode x, int k1, int k2) {
        if (x == null) return;
        if (x.val > k1) inorder(ans, x.left, k1, k2);
        if (x.val >= k1 && x.val <= k2) ans.add(x.val);
        if (x.val < k2) inorder(ans, x.right, k1, k2);
    }

    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int index = 0;
        TreeNode root = getNext(vals, index++);
        Queue<TreeNode> bfs = new LinkedList<>();
        if (root != null) bfs.offer(root);
        while (!bfs.isEmpty()) {
            TreeNode x = bfs.poll();
            x.left = getNext(vals, index++);
            x.right = getNext(vals, index++);
            if (x.left != null) bfs.offer(x.left);
            if (x.right != null) bfs.offer(x.right);
        }
        return root;
    }

    private TreeNode getNext(String[] vals, int index) {
        if (vals[index].equals("#")) return null;
        return new TreeNode(Integer.parseInt(vals[index]));
    }

    public static void main(String[] args) {
        I0011BinarySearchTreeRange solver = new I0011BinarySearchTreeRange();
        System.out.println(solver.searchRange(solver.deserialize("20,8,22,4,12,#,#,#,#,#,#"), 10, 22));
    }
}
