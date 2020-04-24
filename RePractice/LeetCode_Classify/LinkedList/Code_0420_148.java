package RePractice.LeetCode_Classify.LinkedList;

import java.util.PriorityQueue;

public class Code_0420_148 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode sortList(ListNode head) {
        int n = 0;
        for (ListNode cur = head; cur != null;cur = cur.next){
            n++;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (int i = 1; i < n; i *= 2){
            ListNode cur = dummy;
            for (int j = 0;j + i < n; j += i * 2){
                ListNode left = cur.next , right = cur.next;
                for (int k = 0; k < i;k++){
                    right = right.next;
                }
                int l = 0, r = 0;
                while (l < i && r < i && right != null){
                    if (left.val <= right.val){
                        cur.next = left;
                        cur = left;
                        left = left.next;
                        l++;
                    }else {
                        cur.next = right;
                        cur = right;
                        right = right.next;
                        r++;
                    }

                }
                while (l < i){
                    cur.next = left;
                    cur = left;
                    left = left.next;
                    l++;
                }
                while (r < i && right != null){
                    cur.next = right;
                    cur = right;
                    right = right.next;
                    r++;
                }
                //这一步是接起来！
                cur.next = right;
            }

        }
        return dummy.next;
    }
}

//优先级队列！
    public ListNode sortList1(ListNode head) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode cur = head, dummy = new ListNode(0);
        while (cur != null) {
            q.add(cur);
            cur = cur.next;
        }
        cur = dummy;
        while (!q.isEmpty()) {
            cur.next = q.poll();
            cur = cur.next;
        }
        cur.next = null;//last node, set next to null
        return dummy.next;
    }

