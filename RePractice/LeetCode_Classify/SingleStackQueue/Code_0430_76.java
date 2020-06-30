package RePractice.LeetCode_Classify.SingleStackQueue;

import java.util.HashMap;
import java.util.Map;

public class Code_0430_76 {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        for (char c : chars1){
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        int cnt = map.size();
        String res = "";
        for (int i = 0 , j = 0,c = 0;i < chars.length;i++){
            if (map.containsKey(chars[i])){
                if (map.get(chars[i]) == 1){
                    c++;
                }
            }
            map.put(chars[i],map.getOrDefault(chars[i],0) - 1);
//            if (map.containsKey(chars[j])){
////                while (map.get(chars[j]) < 0){
////                    map.put(chars[j],map.getOrDefault(chars[j],0) + 1);
////                    if (j + 1 < chars.length){
////                        j++;
////                    }
////
////                }
////            }
            //!!!!
            while (map.containsKey(chars[j]) && map.get(chars[j]) < 0 ){
                map.put(chars[j],map.getOrDefault(chars[j],0) + 1);
                if (j + 1 < chars.length){
                    j++;
                }
            }


            if (c == cnt){
                if (res.equals("" )|| res == null || res.length() > i - j + 1){
                    res = s.substring(j , i + 1);

                }
            }
        }
        return res;

    }
}
