package RePractice.LeetCode_Classify.Basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code_0502_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= s.length();i++){
            String temp = s.substring(i,i+10);
            map.put(temp,map.getOrDefault(temp,0) + 1);
            if (map.get(temp) == 2){
                res.add(temp);
            }
        }
        return res;
    }
}
