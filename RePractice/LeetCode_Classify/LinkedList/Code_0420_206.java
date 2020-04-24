package RePractice.LeetCode_Classify.LinkedList;

public class Code_0420_206 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode a = head, b = a.next;
        while(b != null){
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        head.next = null;
        head = a;
        return head;
    }
}
