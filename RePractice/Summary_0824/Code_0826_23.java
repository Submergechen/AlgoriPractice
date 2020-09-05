package RePractice.Summary_0824;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class Code_0826_23 {
    public ListNode merge(ListNode[] lists){
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

    }
}
