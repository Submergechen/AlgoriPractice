package RePractice.SwordOffer0316Twice;

import java.util.Stack;

public class Code_0401_30minStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void add(Integer obj){
        if (obj == null){
            throw new RuntimeException("error!");
        }
        stack.add(obj);
        if (minStack != null){
            int peekOne = minStack.peek();
            minStack.add(obj < peekOne ? obj : peekOne);
        }else {
            minStack.add(obj);
        }
    }

    public Integer getMin(){
        //这步有没有必要？ ！
        if (minStack.isEmpty()){
            return null;
        }
        return minStack.peek();
    }

    public Integer pop(){
        if (minStack.isEmpty()){
            throw new RuntimeException("error!");
        }
        stack.pop();
        return minStack.pop();

    }

    public Integer peek(){
        if (minStack.isEmpty()){
            return null;
        }
        return minStack.peek();
    }

}
