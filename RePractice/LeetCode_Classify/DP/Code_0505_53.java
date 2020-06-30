package RePractice.LeetCode_Classify.DP;

public class Code_0505_53 {
    //比较简单的解法！
    public int maxSubArray(int[] nums) {
        int res = nums[0], sum = nums[0];
        for (int i = 1;i < nums.length;i++){
            sum = Math.max(0,sum);
            sum += nums[i];
            res = Math.max(res,sum);
        }
        return res;
    }
    //dp  从集合的角度来考虑dp问题
    // 动态规划de思路！！ 和其他的dp看起来不一样，这样稍微好理解一些
    public int maxSubArray1(int[] nums) {
        int res = Integer.MIN_VALUE;
        int last = 0;
        for (int i = 0;i < nums.length ;i++){
            int now = Math.max(last,0) + nums[i];
            res = Math.max(res , now);
            last = now;
        }
        return res;
    }
}
