package RePractice.Summary_0824.LinkedList;

import java.util.Stack;

public class Code_0830_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> res = new Stack<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null){
            stack1.push(cur1);
            cur1 = cur1.next;
        }

        while (cur2 != null){
            stack2.push(cur1);
            cur1 = cur2.next;
        }
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0 ){
            carry = (stack1.isEmpty() ? 0 : stack1.pop().val) +
                    (stack2.isEmpty() ? 0 : stack2.pop().val) + carry;
            res.push(new ListNode(carry % 10));
            carry = carry / 10;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode cur = dummy;
        while (!res.isEmpty()){
            ListNode temp = res.pop();
            cur.next = temp;
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
