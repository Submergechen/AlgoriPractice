package RePractice.NewPractice_7022;

import java.util.TreeMap;

public class Code_DFSLinkedList_0722_109 {
      public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode sortedListToBST(ListNode head) {
          if (head == null){
              return new TreeNode();
          }

          return dfs(head,null);
    }
    public TreeNode dfs(ListNode head,ListNode tail){
        if (head == tail){
            return null;
        }
        //找到链表中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        TreeNode root = new TreeNode(slow.val);
        root.left = dfs(head,slow);
        root.right = dfs(mid,tail);
        return root;
    }
    public TreeNode dfs2(ListNode node){
        if (node == null){
            return null;
        }
        //找到链表中点
        ListNode slow = node;
        ListNode fast = node;
        ListNode pre = node;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //断开
        pre.next = null;

        ListNode mid = slow.next;
        TreeNode root = new TreeNode(slow.val);
        root.left = dfs2(node);
        root.right = dfs2(slow);
        return root;

    }
    public TreeNode dfs1(ListNode node){
          if (node == null){
              return null;
          }
          //找到链表中点
          ListNode slow = node;
          ListNode fast = node;
          while (fast.next != null && fast.next.next != null){
              slow = slow.next;
              fast = fast.next.next;
          }
          //断开
          ListNode cur = node;
          while (slow != node && cur.next != null && slow != cur.next ){
              cur = cur.next;
          }
          cur.next = null;

          ListNode mid = slow.next;
          TreeNode root = new TreeNode(slow.val);
          root.left = dfs(node);
          root.right = dfs(mid);
          return root;

    }
}
