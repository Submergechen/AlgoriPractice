package RePractice.LeetCode_Classify.LinkedList;

public class Code_0420_237 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public void solution(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
