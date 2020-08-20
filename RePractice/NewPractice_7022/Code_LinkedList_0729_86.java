package RePractice.NewPractice_7022;

public class Code_LinkedList_0729_86 {
      public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode partition(ListNode head, int x) {
          ListNode dummy1 = new ListNode(-1);
          ListNode dummy2 = new ListNode(-2);
          ListNode cur1 = dummy1;
          ListNode cur2 = dummy2;

          while (head != null){
              if (head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
              }else {
                cur2.next = head;
                cur2 = cur2.next;
              }
              head = head.next;
          }
//          cur1.next = null;
//          cur2.next = null;
//          cur1 = dummy1;
//          while (cur1.next != null){
//              cur1 = cur1.next;
//          }
//          cur1.next = dummy2.next;
//          return dummy1.next;
        cur2.next = null;
          cur1.next = dummy2.next;
          return dummy1.next;
    }















    //感觉好难实现！！ 用了太多指针，很复杂！
    public ListNode partition1(ListNode head, int x) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode res = dummy;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null){
            if (cur.val < x){
                ListNode next = res.next;
                res.next = cur;
                pre.next = cur.next;
                cur.next = next;
                res = res.next;
            }else {
                pre = cur;
            }
            cur = pre.next;


        }
        return dummy.next;
    }












}
