package RePractice.NewPractice_7022;

import java.util.Stack;

public class Code_SingleStack_0729_42 {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int res = 0;
        for (int i = 0;i < n;i++){
            left[i] = i == 0 ? height[i] : Math.max(left[i - 1],height[i]);
        }
        for (int i = n - 1;i >= 0;i--){
            right[i] = i == n - 1 ? height[i] : Math.max(right[i + 1],height[i]);
        }
        for (int i = 0;i < n;i++){
            res += Math.min(left[i],right[i]) - height[i];
        }
        return res;
    }

    public int trap1(int[] height) {
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
