package RePractice;

import java.util.Stack;

public class Code_1126_getMinStack {
    private Stack<Integer> Data;
    private Stack<Integer> Min;

    public Code_1126_getMinStack(){
        Data = new Stack<>();
        Min = new Stack<>();
    }

    public void push(int obj){
        Data.push(obj);
        if (Min.isEmpty()){
            Min.push(obj);
        }else {
            Min.push(obj < Min.peek() ? obj : Min.peek());
        }

    }

    public Integer getMin(){
        if (Min.isEmpty()){
            throw new RuntimeException("empty");
        }
        return Min.peek();
    }



    public Integer pop(){
        if (Min.isEmpty()){
            throw new RuntimeException("empty");
        }
        Data.pop();
        return Min.pop();
    }
}
