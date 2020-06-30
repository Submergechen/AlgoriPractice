package RePractice.SwordOffer0316Twice;

/**
 * 这个题要重复 多写一写！！！
 * 这种方法很不一样
 *
 * 考虑多种情况！
 * 把要删除的那个给覆盖掉！
 */
public class Code_0331_18deleteNode {
    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // 1。 空节点
    // 2。 只有一个节点,删除头节点，或者尾节点

    // 3。 正常情况
    public Node  solution(Node head , Node deleteOne){
        if (head == null || deleteOne == null){
            throw new RuntimeException("error!");
        }

        if (head.next == null){
            head = null;
            return head;
        }
        if (deleteOne.next == null){
            Node cur = head;
            while (cur.next != deleteOne){
                cur = cur.next;
            }
            cur.next = null;
            return head;
        }
        //normal

        Node temp = deleteOne.next;
        deleteOne.value  = temp.value;
        deleteOne.next = temp.next;
        return head;
    }

    // 这个题目，头节点是有可能被删掉的！ 所以需要定义一个虚拟头节点
    //  虚拟头节点常用的东西！
    public Node deleteDulicate(Node head){
        if (head == null || head.next == null){
            return head;
        }

//        Node pre = head;
//        Node cur = null;
//        Node post = null;
//        while (pre.next != null){
//            cur = pre.next;
//            post = cur.next;
//            while (cur.value == post.value){
//                cur = post;
//                post = post.next;
//            }
//            pre.next = post.next;
//        }


        //

        Node dummy = new Node(-1);
        dummy.next = head;
        Node pre = dummy;
        while (pre.next != null){
            Node cur = pre.next;
            while (cur != null && pre.next.value == cur.value){
                cur = cur.next;
            }
            if (pre.next.next == cur){
                pre = pre.next;
            }else {
                pre.next = cur;
            }
        }
        return dummy.next;
    }
}


