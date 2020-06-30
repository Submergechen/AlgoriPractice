package RePractice.LeetCode_Classify.Basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code_0502_1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null){
            return new int[]{};
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length ;i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]) , i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
