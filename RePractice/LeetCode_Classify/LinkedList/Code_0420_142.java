package RePractice.LeetCode_Classify.LinkedList;

public class Code_0420_142 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next.next == null || head.next == null ){
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
//        while (fast != null  && fast != slow){
////            fast = fast.next.next;
////            slow = slow.next;
////        }
////        if (fast == null){
////            return null;
////        }
        while (fast != slow){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            fast = head.next.next;
            slow = head.next;
        }

        //如果不相等 就返回null

        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
