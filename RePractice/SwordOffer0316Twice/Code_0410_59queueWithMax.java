package RePractice.SwordOffer0316Twice;

import java.util.LinkedList;

public class Code_0410_59queueWithMax {
    LinkedList<Integer> qMax = new LinkedList<>();
    LinkedList<Integer> q = new LinkedList<>();

    public Integer max(){
        if (qMax.isEmpty()){
            return null;
        }
        return qMax.peekFirst();
    }

    //insert
    public void push_back(Integer obj){
        while (!qMax.isEmpty() && qMax.peekLast() <= obj){
            qMax.pollLast();
        }
        qMax.add(obj);
    }

    //出来前面一个
    public void pop_front(){

    }
}
