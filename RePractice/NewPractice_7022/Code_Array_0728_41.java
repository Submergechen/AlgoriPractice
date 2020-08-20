package RePractice.NewPractice_7022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code_Array_0728_41 {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0;i < n;i++){
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                swap(nums,nums[i] - 1,i);
            }
        }
        for (int i = 0;i < n;i++){
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;

    }
    public void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //自己最开始的做法
    public int firstMissingPositive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //如果输入一个最大的integer的数 会溢出！
        long maxV = 1;
        for (int num : nums){
            set.add(num);
            maxV = Math.max(maxV,num);
        }
        int res = 0;
        //为什么+1 有可能这些数都有，比如123 最小的是4
        for (int i = 1;i <= maxV + 1L;i++){
            if (!set.contains(i)){
               res = i;
               //这里必须break 不然会继续找
               break;
            }
        }
        return res;
    }
}
