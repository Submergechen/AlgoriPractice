package RePractice.SwordOffer0316Twice;

/**
 * 1.少写两个， 一个是遍历的时候n-- 忘记写了
 * 第二个是cur2 忘记了
 *
 */
public class Code_0407_52findFirstCommonNode {
    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node solution(Node headA ,Node headB){
        if (headA == null || headB == null){
            return headA == null && headB == null ? headA : null;
        }
        int n = 0;
        Node cur1 = headA;
        Node  cur2 = headB;
        while (cur1 != null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2 != null){
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2){
            return null;
        }
        cur1 = n > 0 ? headA : headB;
        // cur2 = cur1 == headA ? headB : headA;
        cur2 = cur1 == headA ? headB : headA;

        n = Math.abs(n);
//        while (n > 0){
//            cur1 = cur1.next;
//        }
        while (n > 0){
            cur1 = cur1.next;
            n--;
        }
        while (cur1.value != cur2.value){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
