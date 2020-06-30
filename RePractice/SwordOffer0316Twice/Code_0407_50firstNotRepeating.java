package RePractice.SwordOffer0316Twice;

import java.util.HashMap;
import java.util.Map;

public class Code_0407_50firstNotRepeating {
    //存两次，第一次把 字符和对应次数存进去
    //第二次， 循环一遍，如果发现 次数为1  就返回即可
    public char solution(String str){
        if (str == null){
            throw new RuntimeException("error!");
        }
        char[] chars = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();

        for (char x: chars){
            map.put(x,map.getOrDefault(x,0) + 1);
        }

        for (char x : chars){
            if (map.get(x) == 1){
                return x;
            }
        }
        return '#';

    }
}
