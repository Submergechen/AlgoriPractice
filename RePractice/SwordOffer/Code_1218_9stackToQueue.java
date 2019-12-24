package RePractice.SwordOffer;

import java.util.Stack;

public class Code_1218_9stackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void add(Integer obj){
        if (obj == null){
            return;
        }
        stack1.push(obj);
    }

    public Integer poll(){
        if (stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("队列为空");
        }
        //判断条件是 stack2.isEmpty() 还是这个
        if (!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        return stack2.pop();

    }

    public Integer peek(){
        if (stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }
        if (!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
        return stack2.peek();
    }
}
