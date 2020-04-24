package RePractice.LeetCode_Classify.LinkedList;

public class Code_0420_61 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * 这里的k可能次数很大，所以要取一下模！
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int n = 0;
        for(ListNode cur = head;cur != null ;cur = cur.next){
            n++;
        }
        k = k % n;
        ListNode first = head;
        while(k-- != 0){
            first = first.next;
        }
        ListNode second = head;
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = head;
        head = second.next;
        second.next = null;
        return head;
    }
}
