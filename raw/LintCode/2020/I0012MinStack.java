package lintcode;

import java.util.Stack;

/*

    描述
    实现一个栈, 支持以下操作:

    push(val) 将 val 压入栈
    pop() 将栈顶元素弹出, 并返回这个弹出的元素
    min() 返回栈中元素的最小值
    要求 O(1) 开销.

*/

public class I0012MinStack {

    public class MinStack {

        private Stack<Integer> nums;
        private Stack<Integer> mins;

        public MinStack() {
            nums = new Stack<>();
            mins = new Stack<>();
        }
    
        public void push(int number) {
            if (mins.isEmpty() || mins.peek() >= number) mins.push(number);
            nums.push(number);
        }
    
        public int pop() {
            if (mins.peek().equals(nums.peek())) mins.pop();
            return nums.pop();
        }
    
        public int min() {
            return mins.peek();
        }
    }
}
