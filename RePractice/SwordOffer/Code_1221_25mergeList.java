package RePractice.SwordOffer;

//还有一个递归版本没写！ 补上！！
public class Code_1221_25mergeList {
    class Node{
        private int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public Node mergeList(Node head1,Node head2){
        //忘记找头节点了
        if (head1 == null || head2 == null){
            return head1 == null ? head2: head1;
        }
        Node newHead = null;
        Node res = null;
        if (head1.value <= head2.value){
            newHead = head1;
            res = head1;
            head1 = head1.next;
        }else{
            newHead = head2;
            res = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null){
            if (head1.value <= head2.value){
                res.next = head1;
                //连接完以后，res还要放过去！！ 这里自己用手画一下过程就知道l ！！
                res = head1;
                head1 = head1.next;
            }else {
                res.next = head2;
                res = head2;
                head2 = head2.next;
            }
        }
        /*
        if (head1 == null){
            while (head2 != null){
                res.next = head2;
                res = head2;
                head2 = head2.next;
            }
        }else if (head2 == null){
            while (head1 != null){
                res.next = head1;
                res = head1;
                head1 = head1.next;
            }
        }*/
        //这里是链表 和之前那个有点不一样， 不用循环 一个个去连接，所以上面注释里写的不对！！

        if (head1 == null){
            res.next = head2;
        }else {
            res.next = head1;
        }

        return res;

    }

    public Node mergeList1(Node head3,Node head4){
        if (head3 == null){
            return head4;
        }
        if (head4 == null){
            return head3;
        }

        if (head3.value < head4.value){
            head3.next = mergeList1(head3.next , head4);
            return head3;
        }else {
            head4.next = mergeList1(head3, head4.next);
            return head4;
        }

    }
}
