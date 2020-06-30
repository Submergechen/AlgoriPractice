package RePractice.LeetCode_Classify.SingleStackQueue;

import java.util.Stack;

public class Code_0501_155 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    /** initialize your data structure here. */
    public Code_0501_155() {

    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()){
            min.push(x);
        }else {
            min.push(Math.min(x,min.peek()));
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
