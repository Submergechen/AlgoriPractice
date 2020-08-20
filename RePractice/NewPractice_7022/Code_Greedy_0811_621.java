package RePractice.NewPractice_7022;

import java.util.*;

public class Code_Greedy_0811_621 {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char task : tasks){
            map.put(task,map.getOrDefault(task,0) + 1);
        }
        int maxCount = 0;
        for(char temp : map.keySet()){
            maxCount = Math.max(maxCount,map.get(temp));
        }
        int p = 0;
        for(char temp : map.keySet()){
            if(map.get(temp) == maxCount){
                p++;
            }
        }
        int res = (maxCount - 1) * (n + 1) + p;
        return Math.max(res,len);
    }
}
