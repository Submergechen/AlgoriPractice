package RePractice.NewPractice_7022;

public class Code_LinkedList_0729_328 {
      public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  //比较好de原地做法
    public ListNode oddEvenList(ListNode head) {
          ListNode odd = head , even = head.next,evenHead= even;
          while (even != null && even.next != null){
              odd.next = odd.next.next;
              even.next = even.next.next;
              odd = odd.next;
              even = even.next;
          }
          odd.next = evenHead;
          return head;
    }

    //自己的方法
    public ListNode oddEvenList1(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-2);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        int flag = 1;
        while (head != null){
            if (flag % 2 == 1){
                cur1.next = head;
                cur1 = head;
            }else {
                cur2.next = head;
                cur2 = head;
            }
            flag++;
            head = head.next;
        }
        cur2.next = null;
        cur1.next = dummy2.next;
        return dummy1.next;
    }












}
