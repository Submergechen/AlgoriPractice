package RePractice.LeetCode_Classify.Basic;

import java.util.Iterator;
import java.util.LinkedList;

//第三题

//这个方法是最好de， 用一个链表！！ 链表数组，每一个链表单元里加一个新建链表！
class MyHashMap {
    LinkedList<KeyValue> [] map;

    public class KeyValue{
        int key;
        int value;

        public KeyValue(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new LinkedList[10000];
    }


    private int hash(int key){
        return key % 10000;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = hash(key);
        if (map[bucket] == null){
            map[bucket] = new LinkedList<>();
            map[bucket].add(new KeyValue(key,value));
        }else {
            Iterator<KeyValue> iter = map[bucket].iterator();
            while (iter.hasNext()){
                KeyValue temp = iter.next();
                if (temp.key == key){
                    temp.value = value;
                    return;
                }
            }
            map[bucket].add(new KeyValue(key,value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = hash(key);
        if (map[bucket] == null){
            return -1;
        }else {
            Iterator<KeyValue> iter = map[bucket].iterator();
            while (iter.hasNext()){
                KeyValue temp = iter.next();
                if (temp.key == key){
                    return temp.value;
                }

            }
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = hash(key);
        if (map[bucket] != null){
            Iterator<KeyValue> iter = map[bucket].iterator();
            while (iter.hasNext()){
                KeyValue temp = iter.next();
                if (temp.key == key){
                    iter.remove();
                    return;
                }
            }
        }

    }
}
public class Code_0502_706 {
    LinkedList<KeyValue>[] map;

    public class KeyValue {
        int key;
        int value;

        public KeyValue(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int hash(int n) {
        return n % 1000;
    }

    /** Initialize your data structure here. */
    public Code_0502_706() {
        map = new LinkedList[1000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = hash(key);

        if (map[bucket] == null) {
            map[bucket] = new LinkedList<>();
            map[bucket].add(new KeyValue(key, value));
        }
        else {
            Iterator<KeyValue> iter = map[bucket].iterator();

            while (iter.hasNext()) {
                KeyValue pair = iter.next();

                if (pair.key == key) {
                    pair.value = value;
                    return;
                }
            }

            map[bucket].add(new KeyValue(key, value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = hash(key);

        if (map[bucket] == null) {
            return -1;
        }
        else {
            Iterator<KeyValue> iter = map[bucket].iterator();

            while (iter.hasNext()) {
                KeyValue pair = iter.next();

                if (pair.key == key) {
                    return pair.value;
                }
            }

            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = hash(key);

        if (map[bucket] != null) {
            Iterator<KeyValue> iter = map[bucket].iterator();

            while (iter.hasNext()) {
                KeyValue pair = iter.next();

                if (pair.key == key) {
                    iter.remove();
                    return;
                }
            }
        }
    }
}

//比较标准

public class MyHashMap {
    public class Entry
    {
        public final int key;
        public int value;

        private Entry(int key, int value)
        {
            this.key = key;
            this.value = value;
            size++; // one more key in the map.
        }

        public String toString() { return key + "=" + value; }
    }

    private int size;
    private List<Entry>[] buckets;
    private void setupBuckets(int size) {
        buckets = new List[size];
        for(int i=0; i < size; i++) buckets[i] = new ArrayList();
    }
    MyHashMap() { setupBuckets(1); }

    static final double LOAD_FACTOR = .9;
    private void rehash() // controls capacity.
    {
        if(size < buckets.length*LOAD_FACTOR) return;
        List<Entry>[] old = buckets;
        setupBuckets(buckets.length<<1);
        for(List<Entry> oldBucket : old) for(Entry entry : oldBucket) getBucket(entry.key).add(entry);
    }

    public void put(int key, int value) {
        rehash();
        Entry entry = getEntry(key);
        if(entry != null) entry.value = value;
        else getBucket(key).add( new Entry(key, value) );
    }
    public void remove(int key) {
        if(getBucket(key).remove(getEntry(key))) size--;
    }
    public int get(int key) {
        Entry entry = getEntry(key);
        return entry != null ? entry.value : -1;
    }
    private Entry getEntry(int key) {
        for(Entry entry : getBucket(key)) if(entry.key == key) return entry;
        return null;
    }

    private List<Entry> getBucket(int key) {
        return buckets[key & buckets.length-1];
    }
}

//bst实现！ 效率很高！
class MyHashMap {

    private static final int SET_DEFAULT_VALUE = 1;
    private int maxKey;
    private BST[] table;
    private int tableSize;

    public MyHashMap() {
        maxKey = 1000000;
        tableSize = (maxKey / ((int) Math.sqrt(maxKey)));
        table = new BST[tableSize];
    }

    public void add(int key) {
        put(key, SET_DEFAULT_VALUE);
    }

    public void remove(int key) {
        int indexOfKey = getKeyPosInTable(key);
        BST chainList = table[indexOfKey];
        if (chainList != null) {
            chainList.removeKey(key);
        }
    }

    public void put(int key, int value) {
        int indexOfKey = getKeyPosInTable(key);
        BST chainList = table[indexOfKey];
        if (chainList == null) {
            chainList = new BST();
            table[indexOfKey] = chainList;
        }
        chainList.addAndUpdate(key, value);
    }

    public boolean contains(int key) {
        int indexOfKey = getKeyPosInTable(key);
        BST chainList = table[indexOfKey];
        if (chainList != null) {
            return chainList.containsKey(key);
        } else {
            return false;
        }
    }

    public int get(int key) {
        int indexOfKey = getKeyPosInTable(key);
        BST bst = table[indexOfKey];
        if (bst != null) {
            return bst.getVal(key);
        } else {
            return -1;
        }
    }

    private int getKeyPosInTable(int key) {
        if (key > maxKey || key < 0) {
            throw new RuntimeException("invalid key, not design for the key:" + key);
        }
        return key % tableSize;
    }

    static class BST {

        private TreeNode root;
        private int size;

        public BST() {
            size = 0;
        }

        private static TreeNode deleteNode(TreeNode node, int key) {
            if (node == null) {
                return null;
            }

            if (node.key > key) {
                node.left = deleteNode(node.left, key);
            } else if (node.key < key) {
                node.right = deleteNode(node.right, key);
            } else {
                if (node.right == null) {
                    node = node.left;
                } else {
                    TreeNode successor = getMostLeftNode(node.right);
                    //we are replacing current node with the smallest node in the right child branch.
                    node.key = successor.key;
                    node.val = successor.val;//!!! replace with the successor, and delete the it.
                    node.right = deleteNode(node.right, successor.key);
                }
            }
            return node;
        }

        private static TreeNode getMostLeftNode(TreeNode node) {
            if (node.left == null) {
                return node;
            } else {
                return getMostLeftNode(node.left);
            }
        }

        public boolean containsKey(int key) {
            TreeNode cur = root;
            while (cur != null) {
                final int curKey = cur.key;
                if (curKey == key) {
                    return true;
                } else if (curKey < key) {
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            }
            return false;
        }

        public void addAndUpdate(int key, int val) {

            insertIntoBST(key, val);
        }

        public void insertIntoBST(int key, int val) {
            final TreeNode newNode = new TreeNode(key, val);
            if (root == null) {
                root = newNode;
                return;
            }
            TreeNode cur = root;
            TreeNode prev = null;
            boolean keyNotExist = true;
            while (cur != null) {
                prev = cur;
                if (cur.key == key) {
                    keyNotExist = false;
                    cur.val = val;
                    break;
                } else if (cur.key > key) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            if (keyNotExist) {
                {
                    if (prev.key > key) {
                        prev.left = newNode;
                    } else {
                        prev.right = newNode;
                    }
                }
            }
        }

        private TreeNode getNodeByKey(int key) {
            TreeNode cur = root;
            while (cur != null) {
                final int curKey = cur.key;
                if (curKey == key) {
                    return cur;
                } else if (curKey < key) {
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            }
            return null;
        }

        public int getVal(int key) {
            TreeNode node = getNodeByKey(key);
            return node == null ? -1 : node.val;
        }

        public void removeKey(int key) {
            root = deleteNode(root, key);
        }

        private boolean isEmpty() {
            return size == 0;
        }

        static class TreeNode {
            TreeNode left;
            TreeNode right;
            int val;
            int key;

            TreeNode(int key, int val) {
                this.val = val;
                this.key = key;
            }
        }
    }
}