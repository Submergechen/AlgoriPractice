package RePractice.LeetCode_Classify.SingleStackQueue;

import java.util.Stack;

public class Code_0501_42 {
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ;i < height.length; i++){
            int last = 0;
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]){
                int t = stack.peek();
                stack.pop();
                res += (i - t - 1) * (height[t] - last);
                last = height[t];
            }
            if (!stack.isEmpty()){
                res += (i - stack.peek() - 1) * (height[i] - last);
            }
            stack.push(i);
        }
        return res;

    }
}
