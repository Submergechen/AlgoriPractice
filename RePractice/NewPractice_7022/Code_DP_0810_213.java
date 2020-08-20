package RePractice.NewPractice_7022;

import javax.crypto.spec.DESedeKeySpec;
import java.util.Stack;

public class Code_DP_0810_213 {
    public int rob(int[] nums) {
        return Math.max(helper1(nums,1,nums.length - 1),helper1(nums,0,nums.length - 2));
    }
    public int helper1(int[] nums,int start,int end){
        int include = 0, exclude = 0;
        for (int j = start; j <= end; j++) {
            int i = include, e = exclude;
            include = e + nums[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }

    //滚动数组的形式！
    public int helper(int[] nums,int start,int end){
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int first = 0;
        int second = 0;

        for (int i = start ; i <= end; i++){
            int temp = Math.max(second,first + nums[i]);
            first = second;
            second = temp;
        }
        return second;
    }


}
