package RePractice.SwordOffer;

import java.util.Queue;

public class Code_1218_9queueToStack {
    Queue<Integer> data;
    Queue<Integer> help;

    public Code_1218_9queueToStack() {
        this.data = data;
        this.help = help;
    }

    public void push(Integer obj){
        data.add(obj);
    }

    public Integer pop(){
        if (data.isEmpty()){
            throw new RuntimeException("empty!");
        }
        while (data.size() != 1){
            help.add(data.poll());
        }
        int res = data.poll();
        swap(data,help);
        return res;
    }

    public Integer peek(){
        if (data.isEmpty()){
            return null;
        }
        while (data.size() != 1){
            help.add(data.poll());
        }
        int res = data.poll();
        help.add(res);
        swap(data,help);
        return res;
    }

    public void swap(Queue<Integer> i ,Queue<Integer> j){
        Queue<Integer> tmep = i;
        i = j;
        j = tmep;
    }
}
