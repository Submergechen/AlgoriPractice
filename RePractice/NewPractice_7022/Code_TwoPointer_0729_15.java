package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_TwoPointer_0729_15 {


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0;i < n - 2;i++){
            if (i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            if (nums[i] > 0){
                break;
            }
            int left = i + 1;
            int right = n - 1;
            int target = -nums[i];

            while (left < right){
                int temp = nums[left] + nums[right];
                if (temp == target){
                    res.add(Arrays.asList(new Integer[]{nums[i],nums[left],nums[right]}));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    right--;
                    while (right > left && nums[right] == nums[right + 1]){
                        right--;
                    }
                }else if (temp > target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }


}
