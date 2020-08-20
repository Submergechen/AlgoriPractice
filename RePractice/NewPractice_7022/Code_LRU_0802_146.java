package RePractice.NewPractice_7022;

import java.awt.peer.CanvasPeer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Code_LRU_0802_146 {
    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(){
        }

        public Node(int key,int value){
            this.key = key;
            this.value = value;
            }

        }

    Node dummyHead = new Node();
    Node dummyTail = new Node();
    int capacity;
    Map<Integer,Node> map;
    public Code_LRU_0802_146(int capacity) {
        this.capacity = capacity;
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        map = new HashMap<>(2);
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node temp = map.get(key);
            remove(temp);
            insertToHead(temp);
            return temp.value;
        }
        return -1;
    }


    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node temp = map.get(key);
            temp.value = value;
            remove(temp);
            insertToHead(temp);
        } else {
            if (map.size() == capacity){
                map.remove(dummyTail.pre.key);
                remove(dummyTail.pre);

            }
            Node temp = new Node(key,value);
            insertToHead(temp);
            map.put(key,temp);

        }

    }


    public void insertToHead(Node node){
        Node dummyNext = dummyHead.next;
        node.pre = dummyHead;
        dummyHead.next = node;
        node.next = dummyNext;
        dummyNext.pre = node;
    }
    public void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

class LRUCache {

    final Node head = new Node(0, 0);
    final Node tail = new Node(0, 0);
    final Map<Integer, Node> map;
    final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int res = -1;
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            insertToHead(n);
            res = n.value;
        }
        return res;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            n.value = value;
            insertToHead(n);
        } else {

            if(map.size() == capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node n = new Node(key, value);
            insertToHead(n);
            map.put(key, n);
        }
    }

    private void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void insertToHead(Node n){
        Node headNext = head.next;
        head.next = n;
        headNext.prev = n;
        n.prev = head;
        n.next = headNext;
    }

    class Node{
        Node prev, next;
        int key, value;
        Node(int k, int v){
            key = k;
            value = v;
        }
    }
