package RePractice;

import java.util.LinkedList;
import java.util.Queue;

public class Code_1127_QueueStack {
    private Queue<Integer> Data;
    private Queue<Integer> Help;

    public Code_1127_QueueStack(){
        Data = new LinkedList<>();
        Help = new LinkedList<>();
    }

    public void push(int obj){
        Data.add(obj);
    }

    public Integer peek(){
        if (Data.isEmpty()){
            throw new RuntimeException("empty");
        }
        while (Data.size() != 1){
            Help.add(Data.poll());
        }
        int target = Data.poll();
        Help.add(target);
        swap(Data,Help);
        return target;
    }

    public Integer pop(){
        if (Data.isEmpty()){
            throw new RuntimeException("empty");
        }
        while (Data.size() != 1){
            Help.add(Data.poll());
        }
        int target = Data.poll();
        swap(Data,Help);
        return target;
    }

    public void swap(Queue<Integer> data , Queue<Integer> help){
        Queue<Integer> temp = data;
        data = help;
        help = temp;
    }
}
