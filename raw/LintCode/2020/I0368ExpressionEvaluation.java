package lintcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class I0368ExpressionEvaluation {

    Deque<String> currentLevel = new ArrayDeque<>();
    Stack<Deque<String>> previousLevels = new Stack<>();

    private void startNextLevel() {
        previousLevels.push(currentLevel);
        currentLevel = new ArrayDeque<>();
    }

    private void endCurrLevel() {
        process("*/");
        process("+-");
        if (previousLevels.isEmpty()) return;
        Deque<String> prev = previousLevels.pop();
        if (!currentLevel.isEmpty()) prev.offerLast(currentLevel.pollFirst());  // against "()" case
        currentLevel = prev;
    }

    private String eval(String l, String op, String r) {
        int L = Integer.parseInt(l);
        int R = Integer.parseInt(r);
        if (op.equals("+")) return L + R + "";
        if (op.equals("-")) return L - R + "";
        if (op.equals("*")) return L * R + "";
        return L / R + "";
    }

    private void process(String operators) {
        Deque<String> aux = new ArrayDeque<>();
        while (!currentLevel.isEmpty()) {
            String x = currentLevel.pollFirst();
            if (operators.indexOf(x) >= 0) x = eval(aux.pollLast(), x, currentLevel.pollFirst());
            aux.offerLast(x);
        }
        currentLevel = aux;
    }

    public int evaluateExpression(String[] expression) {
        for (String s : expression) {
            if (s.equals("(")) startNextLevel();
            else if (s.equals(")")) endCurrLevel();
            else currentLevel.offerLast(s);
        }
        endCurrLevel();
        if (currentLevel.isEmpty()) return 0;
        return Integer.parseInt(currentLevel.pollFirst());
    }
}
