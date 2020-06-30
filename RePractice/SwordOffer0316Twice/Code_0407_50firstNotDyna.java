package RePractice.SwordOffer0316Twice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Code_0407_50firstNotDyna {
    //动态查询   利用一个双指针
    // 一个指针指最前面，一个指针往后面走， 后面一个指针判断是否和前一个指针次数大于1 ，然后前一个指针后移
    // 其实队列的本质是 双指针 ，单调队列和双指针的关联也很大
    // 队首是一个指针，队尾是一个指针
    // 有点类似于， 找栈里面的最小值
    //google
    //加第一个de时候 队列是 g
    //进来第二个o  那么队列里 还是g ,
    //进来第三个 消除了o 那么还是g
    // 也就是 答案一直是从前往后走的，就好像栈里面最小值一样！！
    Map<Character ,Integer> map = new HashMap<>();
    //双指针其实也是队列
    Queue<Character> queue = new LinkedList<Character>();
    //用queue比较省空间，可以把多余的字母去除掉
    public void insert(char ch){
        map.put(ch,map.getOrDefault(ch,0) + 1);
        //大于1的时候就不用加到queue里，否则重复
        if (map.get(ch) > 1){
            //把queue里前面次数大于1的去除！
            while (!queue.isEmpty() && map.get(queue.peek()) > 1){
                queue.poll();
            }
        }else {
            queue.add(ch);
        }
    }

    public char getResult(){
        if (!queue.isEmpty()){
            return '#';
        }else {
            return queue.peek();
        }
    }
}
