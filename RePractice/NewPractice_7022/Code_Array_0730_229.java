package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code_Array_0730_229 {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0 ){
            return new ArrayList<>();
        }
        int n = nums.length;

        List<Integer> res = new ArrayList<>();
        int can1 = 0,can2 = 0;
        int count1 = 0, count2 = 0;
        for (int num : nums){
            if (num == can1){
                count1++;
            }else if (num == can2){
                count2++;
            }else if (count1 == 0){
                can1 = num;
                count1 = 1;
            }else if (count2 == 0){
                can2 = num;
                count2 = 1;
            }else {
                count1--;
                count2--;
            }

        }
        count1 = 0;
        count2 = 0;
        for (int num : nums){
            if (num == can1){
                count1++;
            }else if (num == can2){
                count2++;
            }

        }
        if (count1 > n /3){
            res.add(can1);
        }
        if (count2 > n / 3){
            res.add(can2);
        }
        return res;

    }

}
