package RePractice.SwordOffer0316Twice;

import java.util.HashMap;
import java.util.Map;

/**
 * 真正的解法 用异或运算来解， 我自己感觉和上次那个最开始出现一次的字符很像，用了那个解法，可行
 * 两种做法，异或做法和map
 */
public class Code_0408_56findNubmerAppearOnce {
    //自己的解法
    public int[] solution(int[] nums){
        if (nums == null){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int x : nums){
            map.put(x , map.getOrDefault(x,0) + 1);
        }

        int[] res = new int[2];
        int i = 0;
        for (int x : nums){
            if (map.get(x) == 1){
                res[i] = x;
                if (i != 2){
                    i++;
                }
            }
            //只有在满足条件的时候
//            if (i != 2){
//                i++;
//            }
        }
        return res;
    }
    //异或的做法
    //很漂亮
    public int[] solution3(int[] nums){
        int sum = 0;
        for (int x : nums){
            sum ^= x;
        }
        int k = 0;
        while ( ((sum >> 1) & 1) != 1){
            k++;
        }
        int first = 0;
        for (int x : nums){
            if ( ((x >> k) & 1) == 1 ){
                first ^= x;
            }
        }
        return new int[]{first , first ^ sum};

    }



    //返回唯一一个
    //自己的做法，需要开一个很大de哈希表
    public int solution2(int[] nums){
        if (nums == null){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int x : nums){
            map.put(x , map.getOrDefault(x,0) + 1);
        }

        for (int x : nums){
            if (map.get(x) == 1){
                return x;
            }
            //只有在满足条件的时候
//            if (i != 2){
//                i++;
//            }
        }
        return 0;
    }
}
