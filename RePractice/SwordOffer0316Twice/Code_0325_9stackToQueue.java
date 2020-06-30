package RePractice.SwordOffer0316Twice;

import java.util.Stack;

/**
 * 之前这个部分写的都是错的！！！0325！
 * 两个原则：
 * 1。 stack1往stack2里面倒数据，一定要倒完
 * 2。如果stack2里面还有东西，那就一定不要往stack2里面倒，等stack2里面是空的时候再倒
 */
public class Code_0325_9stackToQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Code_0325_9stackToQueue(Stack<Integer> stack1, Stack<Integer> stack2) {
        this.stack1 = stack1;
        this.stack2 = stack2;
    }

    public void add(Integer obj){
        if (obj == null){
            throw new RuntimeException("error");
        }
        stack1.push(obj);
    }

    public Integer peek(){
        if (stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }
//        while (!stack1.isEmpty()){
//            stack2.push(stack1.pop());
//        }
        dao();
        return stack2.peek();
    }

    public void poll(){
        if (stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }

//        while (!stack1.isEmpty()){
//            stack2.push(stack1.pop());
//        }
        dao();
        stack2.pop();
    }
    public void dao(){
        if (!stack2.isEmpty()){
            return;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
}
