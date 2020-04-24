package RePractice.LeetCode_Classify.LinkedList;

public class Code_0420_92 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    //很好的解法！
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || head.next == null) return head;

        int counter = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstEnd = dummy;

        while (counter < m) {
            firstEnd = firstEnd.next;
            counter++;
        }

        ListNode p1 = firstEnd.next, tempHead = p1, p2 = p1.next;
        counter = m;

        // Reverse list in place while still in m to n range
        while (p2 != null && counter < n) {
            p1.next = p2.next;
            p2.next = tempHead;

            tempHead = p2;
            p2 = p1.next;
            counter++;
        }

        firstEnd.next = tempHead; // Reattach first part with modified second part

        return dummy.next;
    }
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        int index = 0;
        ListNode dummy = new ListNode(-1);
        ListNode current = head;
        ListNode preHead = head;
        ListNode last = head;
        while (current != null) {
            index++;
            ListNode next = current.next;
            if (index > n) {
                break;
            } else if (index >= m) {
                ListNode t = dummy.next;
                dummy.next = current;
                dummy.next.next = t;
            }
            if (index + 1 == m) {
                preHead = current;
                last = next;
            }
            current = next;
        }
        preHead.next = dummy.next;
        last.next = current;
        return m == 1 ? dummy.next : head;
    }

    //过不了！
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if(m == n){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode a = dummy;
        ListNode d = dummy;
        for(int i = 0; i < m - 1;i++){
            a = a.next;
        }
        for(int i = 0;i < n; i++){
            d = d.next;
        }


        ListNode b = a.next;
        ListNode c = d.next;

        ListNode p = b;
        ListNode q = b.next;
        while(q != c){
            ListNode o = q.next;
            q.next = p;
            p = q;
            q = o;
        }
        b.next = c;
        a.next = d;
        return dummy.next;

    }
}
