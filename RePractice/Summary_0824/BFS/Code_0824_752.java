package RePractice.Summary_0824.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Code_0824_752 {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends){
            dead.add(deadend);
        }
        Set<String> isVisited = new HashSet<>();
        String start = "0000";
        isVisited.add("0000");
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int steps = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int j = 0; j < len;j++) {
                String temp = queue.poll();
                //
                if (dead.contains(temp)) {
                    continue;
                }
                if (temp.equals(target)) {
                    return steps;
                }
                for (int i = 0; i < 4; i++) {
                    String up = plusOne(temp, i);
                    if (!isVisited.contains(up)) {
                        isVisited.add(up);
                        queue.add(up);
                    }
                    String down = minusOne(temp, i);
                    if (!isVisited.contains(down)) {
                        isVisited.add(down);
                        queue.add(down);
                    }

                }
            }
            steps++;
        }
        return -1;
    }

    public String plusOne(String s , int j){
        char[] chars = s.toCharArray();
        if (chars[j] == '9'){
            chars[j] = '0';
        }else {
            chars[j] += 1;
        }
        return String.valueOf(chars);
    }
    public String minusOne(String s , int j){
        char[] chars = s.toCharArray();
        if (chars[j] == '0'){
            chars[j] = '9';
        }else {
            chars[j] -= 1;
        }
        return String.valueOf(chars);
    }
}
