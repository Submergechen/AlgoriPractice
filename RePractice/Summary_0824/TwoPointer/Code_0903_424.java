package RePractice.Summary_0824.TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class Code_0903_424 {

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int res = 0;
        int curMaxLen = -1;
        Map<Character,Integer> map = new HashMap<>();
        for (int left = 0, right = 0;right < n;right++){
            char temp = s.charAt(right);
            map.put(temp,map.getOrDefault(temp,0) + 1);
            curMaxLen = Math.max(curMaxLen,map.get(temp));
            while (right - left + 1 - curMaxLen > k){
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0) - 1);
                left++;
            }
            res = Math.max(res,right - left + 1);

        }
        return res;
    }

}
