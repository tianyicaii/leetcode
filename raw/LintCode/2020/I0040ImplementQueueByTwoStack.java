package lintcode;

import java.util.Stack;

public class I0040ImplementQueueByTwoStack {


    public class MyQueue {

        private Stack<Integer> in;
        private Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }
    

        public void push(int element) {
            in.push(element);
        }
    

        public int pop() {
            if (out.isEmpty()) dump();
            return out.pop();
        }
    

        public int top() {
            if (out.isEmpty()) dump();
            return out.peek();
        }

        private void dump() {
            while (!in.isEmpty()) out.push(in.pop());
        }
    }

}
