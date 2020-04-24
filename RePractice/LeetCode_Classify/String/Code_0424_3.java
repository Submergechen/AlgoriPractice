package RePractice.LeetCode_Classify.String;

import java.util.HashMap;
import java.util.Map;

public class Code_0424_3 {
    public int lengthOfLongestSubstring(String s) {
        //双指针算法！！ i j 单调性！
        int res = 0;
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0, j = 0;  i < chars.length; i++ ){
            map.put(chars[i],map.getOrDefault(chars[i],0) + 1);
            while (map.get(chars[i]) > 1){
                map.put(chars[j],map.getOrDefault(chars[j],0) - 1);
                j++;
            }
            res = Math.max(res , i - j + 1);
        }
        return res;
    }
}
