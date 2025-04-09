package lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class I0494StackByQueue {

    public class Stack {

        Queue<Integer> q = new LinkedList<>();
        int sz = 0;

        public void push(int x) {
            q.offer(x);
            sz ++;
        }
    
        public void pop() {
            for (int i = 0; i < sz-1; i++) q.offer(q.poll());
            q.poll();
            sz --;
        }
    
        public int top() {
            for (int i = 0; i < sz-1; i++) q.offer(q.poll());
            int ans = q.peek();
            q.offer(q.poll());
            return ans;
        }
    

        public boolean isEmpty() {
            return sz == 0;
        }
    }

}
