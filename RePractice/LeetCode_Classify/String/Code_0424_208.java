package RePractice.LeetCode_Classify.String;

public class Code_0424_208 {
    //一个判断是否为结尾，还要一个是26个字母的后继节点，初始化为null
    class Node{
        boolean is_end;
        Node[] son;

        public Node() {
            this.is_end = false;
            this.son = new Node[26];
        }
    }
    Node root;
    /** Initialize your data structure here. */
    public Code_0424_208() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        char[] chars = word.toCharArray();
        for (char x : chars){
            int u = x - 'a';
            if (cur.son[u] == null){
                cur.son[u] = new Node();
            }
            cur = cur.son[u];
        }
        cur.is_end = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        char[] chars = word.toCharArray();
        for (char x : chars){
            int u = x - 'a';
            if (cur.son[u] == null){
                return false;
            }
            cur = cur.son[u];
        }
        return cur.is_end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        char[] chars = prefix.toCharArray();
        for (char x : chars){
            int u = x - 'a';
            if (cur.son[u] == null){
                return false;
            }
            cur = cur.son[u];
        }
        return true;
    }
}
