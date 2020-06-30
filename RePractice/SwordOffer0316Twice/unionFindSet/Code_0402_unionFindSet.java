package RePractice.SwordOffer0316Twice.unionFindSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 并查集的使用
 * java版本的   备忘录里面的c++版本更简洁明了
 * 
 */
public class Code_0402_unionFindSet {
    class Node{

    }

    private Map<Node,Node> fatherMap;
    private Map<Node,Integer> nodesNumMap;

    //初始化
    public Code_0402_unionFindSet(List<Node> nodes){
        fatherMap = new HashMap<>();
        nodesNumMap = new HashMap<>();
        for (Node node : nodes){
            fatherMap.put(node,node);
            nodesNumMap.put(node,1);
        }

    }
    //合并
    public void union(Node a ,Node b){
        if (a == null || b == null){
            return;
        }
        Node rootOfA = getRoot(a);
        Node rootOfB = getRoot(b);
        if (rootOfA != rootOfB){
            int numOfA = nodesNumMap.get(rootOfA);
            int numOfB = nodesNumMap.get(rootOfB);
            if (numOfA <= numOfB){
                fatherMap.put(rootOfA,rootOfB);
                nodesNumMap.put(rootOfB,numOfA + numOfB);
            }else {
                fatherMap.put(rootOfB,rootOfA);
                nodesNumMap.put(rootOfA,numOfA + numOfB);
            }
        }

    }

    //查找
    public boolean find(Node a , Node b){
        if (a == null || b == null){
            return false;
        }
        Node rootOfA = getRoot(a);
        Node rootOfB = getRoot(b);
        return rootOfA == rootOfB ;
    }

    //获得根
    public Node getRoot(Node node){
        if (node == null){
            return null;
        }

        Node father = fatherMap.get(node);
        while (father != node){
            node = father;
            father = fatherMap.get(node);
        }
        fatherMap.put(node,father);//做了一次路径压缩
        return father;
    }

    //递归版本
    public Node getRootRecu(Node node){
        if (fatherMap.get(node) == node){
            return node;
        }
        Node father = fatherMap.get(node);
        Node result = getRoot(father);
        fatherMap.put(node,result); // 路径压缩
        return result;
    }
}
