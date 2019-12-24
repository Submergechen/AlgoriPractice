package RePractice.SwordOffer;

import java.net.Inet4Address;
//这个题有点难！！
public class Code_1224_37serialize {
    class TreeNode{
        private int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    public String Serialize(TreeNode root){
        StringBuffer sb = new StringBuffer();
        if (root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.value + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    int index = -1;
    public TreeNode deSerialize(String str){
        index++;
        int len = str.length();
        if (index >= len){
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if (strr[index] != "#"){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = deSerialize(str);
            node.right = deSerialize(str);
        }
        return node;
    }
}
