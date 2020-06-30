package RePractice.SwordOffer0316Twice;

import java.util.Stack;

public class Code_0401_31isPopOrder {
    public boolean ispopOrder(int[] pushV , int[] popV){
        int pushLength = pushV.length;
        int popLength = popV.length;
        if (pushV == null || popV == null || popLength != pushLength){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int pushIndex = 0;
        for (int i = 0 ; i < popLength ; i++){
            int obj = popV[i];
            while (stack.isEmpty() || (stack.peek() != obj)){
                if (pushIndex == pushLength){
                    return false;
                }
                stack.push(pushV[pushIndex++]);
            }
            stack.pop();
        }
        return true;
    }
}
