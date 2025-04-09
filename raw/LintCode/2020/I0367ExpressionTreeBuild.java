package lintcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class I0367ExpressionTreeBuild {

    public class ExpressionTreeNode {
        public String symbol;
        public ExpressionTreeNode left, right;
        public ExpressionTreeNode(String symbol) {
            this.symbol = symbol;
            this.left = this.right = null;
        }
    }

    Deque<ExpressionTreeNode> currentLevel = new ArrayDeque<>();
    Stack<Deque<ExpressionTreeNode>> previousLevels = new Stack<>();

    private void startNextLevel() {
        previousLevels.push(currentLevel);
        currentLevel = new ArrayDeque<>();
    }

    private void endCurrLevel() {
        process("*/");
        process("+-");
        if (previousLevels.isEmpty()) return;
        Deque<ExpressionTreeNode> prev = previousLevels.pop();
        if (!currentLevel.isEmpty()) prev.offerLast(currentLevel.pollFirst());  // against "()" case
        currentLevel = prev;
    }

    private void process(String operators) {
        Deque<ExpressionTreeNode> aux = new ArrayDeque<>();
        while (!currentLevel.isEmpty()) {
            ExpressionTreeNode x = currentLevel.pollFirst();
            if (operators.indexOf(x.symbol) >= 0 && x.left == null) {  // [CAUTION: distinguish operators from different levels]
                x.left = aux.pollLast();
                x.right = currentLevel.pollFirst();
            }
            aux.offerLast(x);
        }
        currentLevel = aux;
    }

    public ExpressionTreeNode build(String[] expression) {
        for (String s : expression) {
            if (s.equals("(")) startNextLevel();
            else if (s.equals(")")) endCurrLevel();
            else currentLevel.offerLast(new ExpressionTreeNode(s));
        }
        endCurrLevel();
        return currentLevel.isEmpty() ? null : currentLevel.pollFirst();
    }
}
