package RePractice.NewPractice_7022;

import java.util.Stack;

public class Code_SingleStack_0811_739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int len = T.length;
        int[] res = new int[len];
        for(int i = len - 1;i >= 0;i++ ){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                stack.pop();
            }
            if(i == len - 1){
                res[i] = 0;
            }else{
                res[i] = stack.peek() == null ? 0 : stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }


}
