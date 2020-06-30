package RePractice.LeetCode_Classify.Dfs;

import java.util.Arrays;
import java.util.Comparator;

public class Code_0429_10_473 {
    boolean[] st;
    public boolean makesquare(int[] nums) {
        st = new boolean[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (sum == 0 || sum % 4 != 0){
            return false;
        }
        Arrays.sort(nums);
        //reverse!
        int i = 0,j = nums.length - 1;
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return dfs(nums, 0,0,sum / 4);
    }
    //u代表枚举到第几条边， cur是当前长度， length是边长度
    public boolean dfs(int[] nums, int u , int cur , int length){
        if (cur == length){
            u++;
            cur = 0;
        }
        if (u == 4){
            return true;
        }
        for (int i = 0; i < nums.length; i++){
            if (!st[i] && cur + nums[i] <= length){
                st[i] = true;
                if (dfs(nums , u,cur + nums[i],length)){
                    return true;
                }
                st[i] = false;
                //剪枝！
                if (cur == 0){
                    return false;
                }
                if (cur + nums[i] == length){
                    return false;
                }
                while (i  + 1 < nums.length && nums[i + 1] == nums[i]){
                    i++;
                }

            }
        }
        return false;
    }
}
