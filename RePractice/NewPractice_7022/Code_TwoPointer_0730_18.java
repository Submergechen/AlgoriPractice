package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_TwoPointer_0730_18 {

    //n 3
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4){
            return new ArrayList<>();
        }
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0;i < n - 3;i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i + 1;j < n - 2;j++){
                //不应该是j >0  是从起始位置开始算！
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int left = j + 1;
                int right = n - 1;

                while (left < right){
                    int temp = nums[left] + nums[right] + nums[i] + nums[j];
                    if (temp == target){
                        res.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[left],nums[right]}));
                        left++;
                        while (left < right && nums[left] == nums[left - 1]){
                            left++;
                        }
                        right--;
                        while (right > left && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }else if (temp < target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return res;
    }


}
