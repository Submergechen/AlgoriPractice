package RePractice.NewPractice_7022;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_LinkedList_0729_23 {
      public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  //priorityQueue
    public ListNode mergeKLists(ListNode[] lists) {
          if (lists == null || lists.length == 0){
              return null;
          }
        //listNode 无法比较大小！ 如果不用自定义conpartor的话！
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (!priorityQueue.isEmpty()){
            cur.next = priorityQueue.poll();
            cur = cur.next;
            if (cur.next != null){
                priorityQueue.add(cur.next);
            }

        }
        return dummy.next;

    }

    public ListNode mergeKLists1(ListNode[] lists) {
       if (lists.length < 1){
           return null;
       }
       if (lists.length == 1){
           return lists[0];
       }
        int len = lists.length;
        ListNode res = merge(lists[0],lists[1]);
        for (int i = 2;i < len;i++){
            res = merge(res,lists[i]);
        }
        return res;
    }


    public ListNode merge(ListNode head1,ListNode head2){
          ListNode dummy = new ListNode(-1);
          ListNode cur = dummy;

          while (head1 != null && head2 != null){
              if (head1.val < head2.val){
                  cur.next = head1;
                  head1 = head1.next;
              }else {
                  cur.next = head2;
                  head2 = head2.next;
              }
              cur = cur.next;
          }
          if (head1 != null){
              cur.next = head1;
          }
          if (head2 != null){
              cur.next = head2;
          }
          return dummy.next;
    }












}
