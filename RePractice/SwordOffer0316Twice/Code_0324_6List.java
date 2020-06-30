package RePractice.SwordOffer0316Twice;

/**
 * 带头节点比较好，以后都用头节点类型的
 */

public class Code_0324_6List {
    static class Node{
        private int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = next;
        }
    }
        //添加一个节点
        public static void add(Node head ,int value){
            Node node = new Node(value);
            if (head == null){ //这步判断有必要吗
                head = node;
            }else {

                Node cur = head;
                while (cur.next != null){
                    cur = cur.next;
                }
                cur.next = node;
                //node.next = null;// 这步多余吗
            }
        }

        public static int remove(Node head , int value){
            // 如果删除的是头节点，如果删除的不是头节点
            if (head == null){
                return -1;
            }
            Node cur = head;
            while (cur.next.value != value && cur.next != null){
                cur = cur.next;
            }
            //
            if (cur.next.value == value && cur.next != null){
                Node aim_node = cur.next;

                cur.next = aim_node.next;
                aim_node.next = null;
                return 1;
            }else {
                return -1;
            }

        }
}
