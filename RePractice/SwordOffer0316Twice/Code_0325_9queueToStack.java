package RePractice.SwordOffer0316Twice;

import java.util.LinkedList;
import java.util.Queue;

public class Code_0325_9queueToStack {
    private Queue<Integer> Data;
    private Queue<Integer> Help;

    public Code_0325_9queueToStack() {
        this.Data = new LinkedList<Integer>();
        this.Help = new LinkedList<Integer>();
    }

    public void add(Integer obj){
        if (obj == null){
            return;
        }
        Data.add(obj);
    }

    public Integer peek(){
//        if (Data.isEmpty() && Help.isEmpty()){
//            return null ;
//        }
        if (Data.isEmpty()){
            throw new RuntimeException("Stack is empty!");
        }
        while (Data.size() > 1){
            Help.add(Data.poll());
        }
        int result = Data.poll();
        Help.add(result);
        swap();
        return result;
    }

    public Integer pop(){
        if (Data.isEmpty() && Help.isEmpty()){
            return null;
        }
        while (Data.size() > 1){
            Help.add(Data.poll());
        }
        Integer result =  Data.poll();
        swap();
        return result;
    }

//    public void swap(Queue<Integer> queue1 , Queue<Integer>queue2){
//        Queue<Integer> temp = queue1;
//        queue1 = queue2;
//        queue2 = temp;
//    }
    public void swap(){
        Queue<Integer> temp = Data;
        Data = Help;
        Help = temp;
    }
}
