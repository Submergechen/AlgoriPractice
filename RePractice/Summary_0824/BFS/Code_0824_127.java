package RePractice.Summary_0824.BFS;

import java.util.*;

public class Code_0824_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 0;
        Set<String> visited = new HashSet<>(wordList);
        visited.remove(beginWord);
        while (!queue.isEmpty()){
            int size = queue.size();
            steps++;
            for (int i = 0;i < size;i++){
                String temp = queue.poll();
                if (temp.equals(endWord)){
                    return steps;
                }
                for (int j = 0;j < temp.length();j++){
                    char[] chars = temp.toCharArray();
                    for (char k = 'a'; k <= 'z';k++){
                        chars[j] = k;
                        String str = new String(chars);

                        if (visited.contains(str)){
                            queue.add(str);
                            visited.remove(str);
                        }
                    }

                }

            }


        }
        return 0;
    }
}
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> word = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()){
            int size = queue.size();
            steps++;
            for (int i = 0;i < size;i++){
                String temp = queue.poll();
                if (temp.equals(endWord)){
                    return steps;
                }
                for (int j = 0;j < temp.length();j++){
                    char[] chars = temp.toCharArray();
                    for (char k = 'a'; k <= 'z';k++){
                        chars[j] = k;
                        String str = new String(chars);

                        if (!visited.contains(str) && word.contains(str)){
                            queue.add(str);
                            visited.add(str);
                        }
                    }

                }

            }


        }
        return 0;
    }
