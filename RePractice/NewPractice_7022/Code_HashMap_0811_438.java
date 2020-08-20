package RePractice.NewPractice_7022;

import java.util.*;

public class Code_HashMap_0811_438 {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int len = p.length();
        char[] sortP = p.toCharArray();
        Arrays.sort(sortP);
        p = String.valueOf(sortP);
        for(int i = 0; i <= s.length() - len ;i++){
            String temp = s.substring(i,i + len);
            //string sort
            char[] tempChar = temp.toCharArray();
            Arrays.sort(tempChar);
            temp = String.valueOf(tempChar);
            if(temp == p || temp.equals(p)){
                res.add(i);
            }

        }
        return res;
    }



}
