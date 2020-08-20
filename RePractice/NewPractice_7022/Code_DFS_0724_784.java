package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.List;

public class Code_DFS_0724_784 {
    List<String> res;

    char[] chars;
    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() < 1){
            return new ArrayList<>();
        }

        chars = S.toCharArray();
        res = new ArrayList<>();

        dfs(chars,0);
        return res;
    }
    public void dfs(char[] chars , int index){
        if (index == chars.length){
            res.add(String.valueOf(chars));
            return;
        }
        if (chars[index] >= '0' && chars[index] <= '9'){
            dfs(chars,index + 1);
        }else {
            chars[index] = Character.toLowerCase(chars[index]);
            dfs(chars,index + 1);
            chars[index] = Character.toUpperCase(chars[index]);
            dfs(chars,index + 1);
        }

//bfs

        class Solution {
            public List<String> letterCasePermutation(String S) {
                if (S == null) {
                    return new LinkedList<>();
                }
                Queue<String> queue = new LinkedList<>();
                queue.offer(S);

                for (int i = 0; i < S.length(); i++) {
                    if (Character.isDigit(S.charAt(i))) continue;
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        String cur = queue.poll();
                        char[] chs = cur.toCharArray();

                        chs[i] = Character.toUpperCase(chs[i]);
                        queue.offer(String.valueOf(chs));

                        chs[i] = Character.toLowerCase(chs[i]);
                        queue.offer(String.valueOf(chs));
                    }
                }

                return new LinkedList<>(queue);
            }
        }
    }
    //为啥这里不行？ 没有考虑到大写吧可能！ 如果遇到大写 处理不了？
    public void dfs1(char[] chars , int index){
        if (index == chars.length){
            res.add(String.valueOf(chars));
            return;
        }

        if (chars[index] >= 'a' && chars[index] <= 'z'){
            chars[index] = (char)(chars[index] - 32);
            dfs(chars,index + 1);

        }else if(chars[index] >= 'A' && chars[index] <= 'Z') {
            chars[index] = (char)(chars[index] + 32);
            dfs(chars,index + 1);
        }else {
            dfs(chars,index + 1);
        }
    }
}
