package RePractice.LeetCode_Classify.LinkedList;

public class Code_0420_83 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode solution(ListNode head){
        if(head == null){
            return null;
        }
        ListNode cur = head;
        while(cur != null){
            if(cur.next != null && cur.next.val == cur.val){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
        }
        return head;
    }
}
