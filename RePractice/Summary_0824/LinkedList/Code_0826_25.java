package RePractice.Summary_0824.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Code_0826_25 {
    public ListNode reverse(ListNode head, int k){
        if (k < 1 || head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        ListNode tail = cur;
        while (true){
            for (int i = 0;i < k;i++){
                tail = tail.next;
                if (tail == null){
                    return dummy.next;
                }
            }
            for (int i = 0;i < k - 1;i++){
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = cur;
                pre.next = next;
            }
            pre = cur;
            cur = pre.next;
        }

    }
}
