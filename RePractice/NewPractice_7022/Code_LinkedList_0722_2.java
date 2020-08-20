package RePractice.NewPractice_7022;

import java.util.List;

public class Code_LinkedList_0722_2 {
      public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          ListNode dummy = new ListNode(-1);
          ListNode tail = dummy;
          int carry = 0;
          while (l1 != null || l2 != null || carry != 0){
              int temp = (l1 != null ? l1.val : 0 )  + (l2 != null ? l2.val : 0 ) + carry;
              tail.next = new ListNode(temp % 10);
              tail = tail.next;
              carry = temp / 10;

              if (l1 != null){
                  l1 = l1.next;
              }
              if (l2 != null){
                  l2 = l2.next;
              }
          }
          return dummy.next;
    }
















  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return new ListNode();
        }

          ListNode cur1 = l1;
      ListNode cur2 = l2;
      long num1 = 0;
      long num2 = 0;
      int i = 1;
      while (cur1 != null){
          num1 = cur1.val * i + num1;

          i *= 10;
          cur1 = cur1.next;
      }
      i = 1;
      while (cur2 != null){
          num2 = cur2.val * i + num2;
          i *= 10;
          cur2 = cur2.next;
      }

      long sum = num1 + num2;
      ListNode dummy = new ListNode(-1);
      ListNode cur = dummy;
      while (sum > 0){
          int temp = (int)sum % 10;
          ListNode newNode = new ListNode(temp);
          cur.next = newNode;
          cur = newNode;
          sum /= 10;
      }
      return dummy.next;

  }
}
