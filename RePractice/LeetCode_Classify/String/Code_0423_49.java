package RePractice.LeetCode_Classify.String;

import java.util.*;

public class Code_0423_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
       // List<List<String >> result = new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<>();

        for (String str : strs){
//            Collections.sort(str, new Comparator<String>() {
//                @Override
//                public int compare(String o1, String o2) {
//                    return o1.compareTo(o2);
//                }
//            });
            char[] chars = str.toCharArray();

            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
//        for (String k :map.keySet()){
//            List<String> res = new ArrayList<>();
//            res.addAll(map.get(k));
//            result.add(res);
//        }
//        return result;
        //高效的写法！！
        return new ArrayList<>(map.values());
    }
}
