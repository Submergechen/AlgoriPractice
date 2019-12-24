package RePractice.SwordOffer;

public class Code_1221_22findKthToTail {
    class Node{
        private int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    //k > length 的情况后面处理
    //只能遍历一次

    public Node find(Node head ,int k){
        if (head == null || k < 0 ){
            throw new RuntimeException("error input");
        }
        Node fast = head, slow = head;

        for (int p = 0; p < k - 1 ;p++){
            fast = fast.next;
            if (fast == null){
                throw new RuntimeException("k value error!");
            }
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
