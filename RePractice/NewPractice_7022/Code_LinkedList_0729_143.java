package RePractice.NewPractice_7022;

import java.util.List;
import java.util.Stack;

public class Code_LinkedList_0729_143 {
      public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public void reorderList(ListNode head) {
        if (head == null || head == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;

        }
        pre.next = null;
        slow = reverse(slow);
        ListNode cur = new ListNode();
        cur = head;
        fast = head;
        int flag = 0;
        while(fast != null && slow != null){
            if(flag % 2 == 0){
                fast = fast.next;
                cur.next = slow;

            }else{
                slow = slow.next;
                cur.next = fast;


            }
            cur = cur.next;
            flag++;


        }
        return;

    }


    public ListNode reverse(ListNode cur){
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }















}
