package RePractice.NewPractice_7022;

public class Code_LinkedList_0722_876 {
      public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  //找中点， 和哪个merge还是不一样啊？！
    public ListNode middleNode(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
