package RePractice.NewPractice_7022;

import java.util.Stack;

public class Code_LinkedList_0727_234 {
      public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    //自己的思路太乱了？！
    public boolean isPalindrome(ListNode head) {
          if (head == null){
              return true;

          }

          ListNode fast = head;
          ListNode slow = head;

          while (fast != null && fast.next != null){
              fast = fast.next.next;
              slow = slow.next;


          }
          if (fast != null){
              slow = slow.next;
          }

          slow = reverse(slow);
          fast = head;
          while ( slow != null){
              if (slow.val != fast.val){
                  return false;
              }
              slow = slow.next;
              fast = fast.next;
          }
          return true;


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
    public boolean isPalindrome1(ListNode head) {
          ListNode cur = head;
          Stack<ListNode> stack = new Stack<>();
          while (cur != null){
              stack.push(cur);
              cur = cur.next;
          }
          cur = head;
          while (!stack.isEmpty() && cur != null){
              if (stack.pop().val != cur.val){
                  return false;
              }
              cur = cur.next;
          }
          return true;
    }















}
