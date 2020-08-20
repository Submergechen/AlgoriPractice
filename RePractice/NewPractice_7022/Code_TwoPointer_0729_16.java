package RePractice.NewPractice_7022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_TwoPointer_0729_16 {


    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3){
            return -1;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int minDis = Integer.MAX_VALUE;
        for (int i = 0;i < n - 2;i++){
            if (i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right){
                int temp = nums[left] + nums[right] + nums[i];
                if (temp == target){
                    res = temp;
                    minDis = 0;
                    //这里直接返回，不用break， break的话 也可以，但是自己没有更新minDis的值，找到以后！
                    //还是漏了点东西
                    return res;
                }else if (temp < target){
                    left++;

                }else {
                    right--;
                }
                if (Math.abs(temp - target) < minDis){
                    res = temp;
                    minDis = Math.abs(temp - target);
                }
            }
        }
        return res;
    }


}
