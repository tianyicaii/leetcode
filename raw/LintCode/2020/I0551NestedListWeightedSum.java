package lintcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}

public class I0551NestedListWeightedSum {
    
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> bfs = new LinkedList<>();
        for (NestedInteger i : nestedList) { bfs.offer(i); }
        int weight = 1;
        int ans = 0;
        while (!bfs.isEmpty()) {
            int N = bfs.size();
            for (int i = 0; i < N; i++) {
                NestedInteger x = bfs.poll();
                if (x.isInteger()) ans += weight * x.getInteger();
                else for (NestedInteger y : x.getList()) { bfs.offer(y); }
            }
            weight++;
        }
        return ans;
    }

    private Deque<NestedInteger> toDeque(List<NestedInteger> nestedList) {
        Deque<NestedInteger> curr = new ArrayDeque<>();
        for (NestedInteger i : nestedList) curr.offerLast(i);
        return curr;
    }

    public int depthSum_(List<NestedInteger> nestedList) {
        int ans = 0;
        Stack<Deque<NestedInteger>> prev = new Stack<>();
        prev.push(toDeque(nestedList));
        
        while (!prev.isEmpty()) {
            int weight = prev.size();
            Deque<NestedInteger> curr = prev.pop();
            if (curr.isEmpty()) continue;
            NestedInteger x = curr.pollFirst();
            if (x.isInteger()) {
                prev.push(curr);
                ans += x.getInteger() * weight;
            }
            else {
                prev.push(curr);
                prev.push(toDeque(x.getList()));
            }
        }
        return ans;
    }
}
