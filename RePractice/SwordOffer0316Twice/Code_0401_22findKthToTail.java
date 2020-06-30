package RePractice.SwordOffer0316Twice;

public class Code_0401_22findKthToTail {
    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    // 第一种， 统计长度 然后找 第n+1-k个  要考虑k 大于总长度这种情况
    public Node solution1(Node head , int k){
        if (head == null || k < 0){
            throw new RuntimeException("error!");
        }
        int len = 0;
        Node cur = head;
        while (cur != null){
            cur = cur.next;
            len++;
        }
        int aim = len + 1 - k;
        if (aim > 0){
            cur = head;
            while (aim > 0){
                cur = cur.next;
                aim--;

            }
            return cur;
        }else {
            throw new RuntimeException("error!");
        }
    }

    //第二种，链表里面使用两个指针
    // 倒数第四个 那么就先走三步
    // 判断里面 .next
    public Node solution2(Node head , int k ){
        if (head == null || k == 0){
            return null;
        }
        Node first = head;
        Node second = head;
        for (int i = 0; i < k -1 ;i++){
            if (first != null){
                first = first.next;
            }else {
                return null;
            }

        }
        while (first != null){
            first = first.next;
            second = second.next;

        }
        return second;
    }
}
