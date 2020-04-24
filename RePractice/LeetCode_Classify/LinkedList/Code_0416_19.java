package RePractice.LeetCode_Classify.LinkedList;

import java.util.List;

public class Code_0416_19 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode solution(ListNode head , int n){
        //加了虚拟头节点以后，不需要判空
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;
        while (n-- != 0){
            first = first.next;
        }
        while (first.next != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return dummy.next;
    }
}
