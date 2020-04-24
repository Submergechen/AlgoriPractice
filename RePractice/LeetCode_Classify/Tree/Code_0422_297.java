package RePractice.LeetCode_Classify.Tree;

import java.util.*;

public class Code_0422_297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //用string build来传递参数参数！！
        StringBuilder sb = new StringBuilder();
        dfs1(root,sb);
        return String.valueOf(sb);
    }

    public void dfs1(TreeNode root , StringBuilder sb){
        if (root == null){
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        dfs1(root.left,sb);
        dfs1(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int u = 0;

        return dfs2(data,u);
    }
    //返回根节点的指针！
    public TreeNode dfs2(String data , int u){
        if (data.indexOf(u) == '#'){
            //跳过一个#号和一个逗号！
            u += 2;
            return null;
        }
        int t = 0;
        boolean is_minus = false;
        if (data.indexOf(u) == '-'){
            is_minus = true;
            u++;
        }
        while (data.indexOf(u) != ','){
            t = t * 10 + data.indexOf(u) - '0';
            u++;
        }
        //跳过逗号！！
        u++;
        if (is_minus){
            t = -t;
        }
        TreeNode root = new TreeNode(t);
        root.left = dfs2(data,u);
        root.right = dfs2(data,u);
        return root;
    }
}
//更高效的做法！！
    public String serialize3(TreeNode root) {
        if(root == null){
            return "null";
        }
        StringBuilder res = new StringBuilder();
        helper(root, res);
        return res.toString();
    }
    private void helper(TreeNode root, StringBuilder res){
        if(root == null){
            res.append("null").append(",");
        }else{
            res.append(root.val).append(",");
            helper(root.left, res);
            helper(root.right, res);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize3(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }
    private TreeNode buildTree(Queue<String> queue){
        String cur = queue.poll();
        if(cur.equals("null") ){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.valueOf(cur));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }



    public String serialize4(TreeNode root) {
        StringBuilder res = new StringBuilder();
        helper4(root,res);
        return res.toString();
    }
    private void helper4(TreeNode root, StringBuilder res){
        if (root == null){
            res.append("null").append(",");
            return;
        }
        res.append(root.val).append(",");
        helper4(root.left,res);
        helper4(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize4(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return buildTree4(queue);

    }
    private TreeNode buildTree4(Queue<String> queue){
        String cur = queue.poll();
        //
//        if (cur == null){
//            return null;
//        }
        //null是一个字符串！！
        if (cur.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(cur));
        node.left = buildTree4(queue);
        node.right = buildTree4(queue);
        return node;

    }
//bfs的做法

    public String serialize1(TreeNode root) {
        String result = "";

        if (root == null) {
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.remove();

            if (node == null) {
                result = result + "null,";
            }
            else {
                result = result + node.val + ",";
                q.add(node.left);
                q.add(node.right);
            }
        }

        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {

        if (data.isEmpty()) {
            return null;
        }
        String[] input = data.split("\\,");

        int rootval = Integer.parseInt(input[0]);
        TreeNode root = new TreeNode(rootval);

        Queue<TreeNode> q = new LinkedList<>();

        int i = 1;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            String l = input[i];
            String r = input[i + 1];

            if (!l.equals("null")) {
                int left = Integer.parseInt(l);
                node.left = new TreeNode(left);
                q.add(node.left);
            }

            if (!r.equals("null")) {
                int right = Integer.parseInt(r);
                node.right = new TreeNode(right);
                q.add(node.right);
            }

            i = i + 2;
            if (i > input.length - 1) {
                break;
            }
        }

        return root;
    }
}
 //bfs的方法

    private static final String LEVEL_SEPARATOR = "#";
    private static final String NULL = "NULL";
    private static final String SEPARATOR = ",";

    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                TreeNode cur = q.poll();
                if (cur == null) sb.append(NULL);
                else {
                    sb.append(cur.val);
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
                if (n > 0) sb.append(SEPARATOR);
            }
            if (!q.isEmpty()) sb.append(LEVEL_SEPARATOR);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] lines = data.split(LEVEL_SEPARATOR);
        if (lines == null || lines.length == 0) return null;
        TreeNode root = new TreeNode(Integer.parseInt(lines[0]));
        List<TreeNode> prev = new ArrayList<>();
        prev.add(root);
        for (int i = 1; i < lines.length; i++) {
            String[] numsStr = lines[i].split(SEPARATOR);
            int idx = 0;
            List<TreeNode> cur = new ArrayList<>();
            for (int j = 0; j < numsStr.length; j += 2) {
                TreeNode left = (numsStr[j].equals(NULL)) ? null : new TreeNode(Integer.parseInt(numsStr[j]));
                TreeNode right = (numsStr[j+1].equals(NULL)) ? null : new TreeNode(Integer.parseInt(numsStr[j+1]));
                TreeNode node = prev.get(idx++);
                node.left = left;
                node.right = right;
                if (left != null) cur.add(left);
                if (right != null) cur.add(right);
            }
            prev = cur;
        }
        return root;
    }
}