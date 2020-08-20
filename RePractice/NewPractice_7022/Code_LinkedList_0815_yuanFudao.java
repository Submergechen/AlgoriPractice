package RePractice.NewPractice_7022;

public class Code_LinkedList_0815_yuanFudao {
// Definition for a Node.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

    public TreeNode solution(ListNode head){
        if (head == null || head.next == null){
            return new TreeNode(head.val);
        }
        return helper(head);
    }

    public TreeNode helper(ListNode head){
        if (head == null ){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head);
        root.right = helper(slow.next);
        return root;
    }

}
