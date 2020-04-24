package RePractice.LeetCode_Classify.LinkedList;

public class Code_0420_160 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode cur1 = headA , cur2 = headB;
        int n = 0;
        while (cur1 != null){
            cur1 = cur1.next;
            n++;
        }
        while (cur2 != null){
            cur2 = cur2.next;
            n--;
        }
        if (cur1 != cur2){
            return null;
        }
        cur1 = n > 0 ? headA : headB;
        cur2 = cur1 == headA ? headB : headA;
        n = Math.abs(n);
        while (n > 0){
            cur1 = cur1.next;
            n--;
        }

        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;

    }

    //巧妙，但是复杂度更高！
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode cur1 = headA , cur2 = headB;
        while (cur1 != cur2){
            if (cur1 != null){
                cur1 = cur1.next;
            }else {
                cur1 = headB;
            }
            if (cur2 != null){
                cur2 = cur2.next;
            }else {
                cur2 = headA;
            }
        }
        return cur1;

    }
}
