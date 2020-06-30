package RePractice.SwordOffer0316Twice;

import java.util.HashMap;
import java.util.Map;

public class Code_0407_48longestSubString {
    //双指针; 将N^2搜索空间降低为N, 双指针构成了滑动窗口; 双指针的使用模板:
    // 1)移动右指针, 直至滑动窗口不满足条件,
    // 2)此时移动左指针, 直至滑动窗口满足条件
    public int solution(String s){
        if (s == null){
            return 0;
        }
        int res = 0;
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (int j = 0,i = 0; i < chars.length; i++){
            map.put(chars[i],map.getOrDefault(chars[i] , 0) + 1);
            if (map.get(chars[i]) > 1){
                while (map.get(chars[j]) == 1){
                    //map.get(chars[i])--;
                    map.put(chars[j] , map.getOrDefault(chars[j] , 0) - 1);
                    j++;
                }
                //map.get(chars[i]) --;
                map.put(chars[j] , map.getOrDefault(chars[j] , 0) -1);
                j++;
            }
            res = Math.max(res , i - j + 1);
        }
        return res;
    }
}
