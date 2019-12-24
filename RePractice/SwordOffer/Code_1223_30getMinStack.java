package RePractice.SwordOffer;

import java.util.Stack;

public class Code_1223_30getMinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public Code_1223_30getMinStack() {
        this.stack = stack;
        this.min = min;
    }

    public void  push(Integer obj){
        stack.push(obj);
        if (min.isEmpty()){
            min.push(obj);
        }else {
            min.push(obj < min.peek() ? obj: min.peek());
        }
        /*if (stack.isEmpty()){
            stack.push(obj);
            min.push(obj);
        }else {
            if (obj <= min.peek()) {
                min.push(obj);
                stack.push(obj);
            } else {
                min.push(min.peek());
                stack.push(obj);
            }
        }*/
    }

    public Integer getMin(){
        if (min.isEmpty()){
            throw new RuntimeException("empty");
        }

        return min.peek();
    }

    public Integer peek(){
        if (stack.isEmpty()){
            return null;
        }
        return min.peek();
    }
    public Integer pop(){
        //都要pop
        if (stack.isEmpty()){
            throw new RuntimeException("empty");
        }
        stack.pop();
        return min.pop();

    }
}
