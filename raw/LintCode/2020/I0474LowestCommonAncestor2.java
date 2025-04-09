package lintcode;

import java.util.Stack;

public class I0474LowestCommonAncestor2 {
    
    class ParentTreeNode {
        public ParentTreeNode parent, left, right;
    }

    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        Stack<ParentTreeNode> pA = getPath(A);
        Stack<ParentTreeNode> pB = getPath(B);
        ParentTreeNode ans = null;
        while (!pA.isEmpty() && !pB.isEmpty() && pA.peek() == pB.peek()) {
            ans = pA.pop();
            pB.pop();
        }
        return ans;
    }

    Stack<ParentTreeNode> getPath(ParentTreeNode x) {
        Stack<ParentTreeNode> ans = new Stack<>();
        while (x != null) {
            ans.push(x);
            x = x.parent;
        }
        return ans;
    }
}
