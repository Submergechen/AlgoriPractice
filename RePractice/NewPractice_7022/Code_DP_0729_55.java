package RePractice.NewPractice_7022;

import java.text.BreakIterator;

public class Code_DP_0729_55 {
    //每次找能遍历到的最大位置
    //贪心
    public boolean canJump(int[] nums) {
        int reach = 0;
        int n = nums.length;
        for (int i = 0;i < n;i++){
            if (i > reach){
                return false;
            }
            reach = Math.max(reach,i + nums[i]);
        }
        return reach >= nums.length - 1;
    }
    //dp
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1;i < n;i++){
            for (int j = i - 1;j >= 0;j--){
                if (dp[j] && nums[j] + j >= i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    //baoli
    public boolean canJump1(int[] nums) {
        boolean can = false;
        dfs(nums,0);
        return can;
    }

    public void dfs(int[] nums , int index){
        if (nums[index] >= nums.length - 1 - index){
            can = true;
            return;
        }
        for (int i = index + 1;i < Math.min(nums.length,index + nums[index]);i++){
            dfs(nums,i);
            if (can){
                return;
            }
        }
    }


}
