package RePractice;

import java.util.Stack;

public class Code_1127_StackQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public Code_1127_StackQueue(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void add(int obj){
        s1.push(obj);
    }

    public Integer peek(){
        if (s1.isEmpty() && s2.isEmpty()){
            throw new RuntimeException("empty");
        }
        if (s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }


    public Integer poll(){
        if (s1.isEmpty() && s2.isEmpty()){
            throw new RuntimeException("empty");
        }
        if (s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
