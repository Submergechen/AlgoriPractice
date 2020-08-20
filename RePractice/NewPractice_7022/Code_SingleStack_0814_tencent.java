package RePractice.NewPractice_7022;

import java.util.Stack;

public class Code_SingleStack_0814_tencent {
    public static int[] solition(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len;i++){
            left[i] = stack.size();
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }

            stack.push(i);
        }
        while (!stack.isEmpty()){
            stack.pop();
        }
        for (int i = len - 1; i >= 0;i--){
            right[i] = stack.size();
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }

            stack.push(i);
        }
        for (int i = 0; i < len;i++){
            res[i] = left[i] + right[i ] + 1;
        }
        return res;
    }


}
