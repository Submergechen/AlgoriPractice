package RePractice.SwordOffer;

import java.util.Stack;

public class Code_1223_31isPopOrder {
    public boolean isOrder(int[] pushV, int[] popV){
        if (pushV.length != popV.length ){
            return false;
        }
        //这句是对的！！
        if (pushV == null || popV == null){
            return pushV == null && popV == null;
        }
        /*Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        stack.push(pushV[j]);
        for (int i = 0 ; i < popV.length ; i++){
            while (stack.peek() != popV[i]){
                if (j == pushV.length){
                    return false;
                }
                j = j + 1;
                stack.push(pushV[j]);
            }
            stack.pop();
        }
        return true;*/
        Stack<Integer> stack = new Stack<Integer>();
        int pushIndex = 0;
        for (int i = 0; i < popV.length;i++){
            while (stack.isEmpty() || (stack.peek() != popV[i]) && pushIndex < pushV.length){
                stack.push(pushV[pushIndex++]);
            }
            if (stack.peek() == popV[i]){
                stack.pop();
            }
        }
        //自己过程其实懂了，但是最后判断错误， 应该是辅助栈是否为空来判断！！
        return stack.isEmpty();
    }
}
