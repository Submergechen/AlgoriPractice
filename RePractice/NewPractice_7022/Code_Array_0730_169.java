package RePractice.NewPractice_7022;

import java.util.HashMap;
import java.util.Map;

public class Code_Array_0730_169 {
    //计数 加数，如果超过一半！ 那么肯定最后count >0
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int count = 1;

        for (int i = 0;i < n;i++){
            if (count == 0){
                count++;
                res = nums[i];
            }else if (res == nums[i]){
                count++;
            }else {
                count--;
            }
        }
        return res;

    }
    //自然而然想到的方法,map
    public int majorityElement1(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        for (int key : map.keySet()){
            if (map.get(key) > n / 2){
                return key;
            }
        }
        return -1;
    }

}
