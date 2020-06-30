package RePractice.LeetCode_Classify.Basic;

import java.util.HashMap;
import java.util.Map;

public class Code_0502_560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hash = new HashMap<>();
        int res = 0;
        //s[-1]  = 0;
        // L -- R  S[R] - S[L - 1]

        hash.put(0,hash.getOrDefault(0,0)+1 );


        for (int i = 0 , sum = 0;i < nums.length ;i++){
            sum += nums[i];
            res += hash.getOrDefault(sum - k , 0);
            hash.put(sum,hash.getOrDefault(sum,0) + 1);
        }
        return res;
    }
}
