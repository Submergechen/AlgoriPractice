package RePractice.Summary_0824;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Code_0909_71 {
    public String simplifyPath(String path) {
        Deque<String> queue = new ArrayDeque<>();
        String[] str = path.split("/");
        for (int i = 0;i < str.length;i++){
            if (str[i].equals(".") || str[i].equals("")){
                continue;
            }else if (str[i].equals("..")){
                if (!queue.isEmpty()){
                    queue.removeLast();
                }

            }else {
                queue.addLast(str[i]);
            }

        }
        if (queue.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.removeFirst()).append("/");
        }
        sb.setLength(sb.length() - 1);
        sb.insert(0,"/");
        return sb.toString();
    }
}
