package RePractice.Summary_0824.DFS;

import java.util.List;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Code_0901_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        return dfs(head,null);
    }

    public TreeNode dfs(ListNode head,ListNode tail){
        if (head == null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        TreeNode temp = new TreeNode(slow.val);
        temp.left = dfs(head,slow);
        temp.right = dfs(mid,tail);
        return temp;
    }
}
