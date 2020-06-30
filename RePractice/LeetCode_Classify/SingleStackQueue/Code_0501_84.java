package RePractice.LeetCode_Classify.SingleStackQueue;

import java.util.Stack;

public class Code_0501_84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        //求 从左到右 每个数左边第一个比它小的坐标
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
//            if (stack.isEmpty()){
//                left[i] = -1;
//            }else {
//                left[i] =
//            }
            left[i] = stack.isEmpty() ? -1:stack.peek();
            stack.push(i);
        }
        //求 从右到左 每个数左边第一个比它小的坐标
        // 2 1 5 6 2 3
        //  6  2 3
        // 2 4
        while (!stack.isEmpty()){
            stack.pop();
        }
        for (int i = n - 1; i >= 0 ;i--){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for (int i = 0 ;i < n; i++){
            res = Math.max(res,heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}
