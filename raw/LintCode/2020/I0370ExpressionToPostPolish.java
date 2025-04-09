package lintcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class I0370ExpressionToPostPolish {

    class Node {
        String str;
        List<String> expr = null;

        Node (String s) { str = s; }

        List<String> getExpr() {
            if (expr == null) promote();
            return expr;
        }

        void promote() {
            expr = new LinkedList<>();
            expr.add(str);
        }
    }

    Deque<Node> currentLevel = new ArrayDeque<>();
    Stack<Deque<Node>> previousLevels = new Stack<>();

    private void startNextLevel() {
        previousLevels.push(currentLevel);
        currentLevel = new ArrayDeque<>();
    }

    private void endCurrLevel() {
        process("*/");
        process("+-");
        if (previousLevels.isEmpty()) return;
        Deque<Node> prev = previousLevels.pop();
        if (!currentLevel.isEmpty()) prev.offerLast(currentLevel.pollFirst());  // against "()" case
        currentLevel = prev;
    }

    private void process(String operators) {
        Deque<Node> aux = new ArrayDeque<>();
        while (!currentLevel.isEmpty()) {
            Node x = currentLevel.pollFirst();
            if (operators.indexOf(x.str) >= 0 && x.expr == null) {  // [CAUTION: distinguish operators from different levels]
                x.promote();
                x.expr.addAll(x.expr.size() - 1, aux.pollLast().getExpr());
                x.expr.addAll(x.expr.size() - 1, currentLevel.pollFirst().getExpr());
            }
            aux.offerLast(x);
        }
        currentLevel = aux;
    }

    public List<String> convertToRPN(String[] expression) {
        for (String s : expression) {
            if (s.equals("(")) startNextLevel();
            else if (s.equals(")")) endCurrLevel();
            else currentLevel.offerLast(new Node(s));
        }
        endCurrLevel();
        if (currentLevel.isEmpty()) return new LinkedList<String>();
        return currentLevel.pollFirst().getExpr();
    }

}
