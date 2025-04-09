package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/*

    描述
    设计一个算法，并编写代码来序列化和反序列化二叉树。将树写入一个文件被称为“序列化”，读取文件后重建同样的二叉树被称为“反序列化”。

    如何反序列化或序列化二叉树是没有限制的，你只需要确保可以将二叉树序列化为一个字符串，并且可以将字符串反序列化为原来的树结构。

    对二进制树进行反序列化或序列化的方式没有限制，LintCode 将您的 serialize 输出作为 deserialize 的输入，它不会检查序列化的结果。

    您在真实的面试中是否遇到过这个题？  
    样例
    样例 1：

    输入：{3,9,20,#,#,15,7}
    输出：{3,9,20,#,#,15,7}
    解释：
    二叉树 {3,9,20,#,#,15,7}，表示如下的树结构：
        3
        / \
        9  20
        /  \
        15   7
    它将被序列化为 {3,9,20,#,#,15,7}
    样例 2：

    输入：{1,2,3}
    输出：{1,2,3}
    解释：
    二叉树 {1,2,3}，表示如下的树结构：
    1
    / \
    2   3
    它将被序列化为 {1,2,3}
    我们的数据是进行 BFS 遍历得到的。当你测试结果 Wrong Answer 时，你可以作为输入调试你的代码。

    你可以采用其他的方法进行序列化和反序列化。

*/

public class I007BinaryTreeSerialization {
    
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

    public String serialize(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        StringBuilder out = new StringBuilder();
        while (!bfs.isEmpty()) {
            TreeNode x = bfs.poll();
            if (x == null) out.append("#,");
            else {
                out.append(x.val + ",");
                bfs.offer(x.left);
                bfs.offer(x.right);    
            }
        }
        return out.substring(0, out.length() - 1);
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
        I007BinaryTreeSerialization solver = new I007BinaryTreeSerialization();
        System.out.println(solver.serialize(solver.deserialize("1,2,3,#,#,#,#")));
    }
}
