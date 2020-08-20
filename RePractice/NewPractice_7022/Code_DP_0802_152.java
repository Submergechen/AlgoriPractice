package RePractice.NewPractice_7022;

public class Code_DP_0802_152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0 ){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 1;i <= n;i++){
            dp[i][0] = dp[i][1] = nums[i - 1];
            dp[i][0] = Math.min(dp[i][0],dp[i - 1][0] * nums[i - 1]);
            dp[i][0] = Math.min(dp[i][0],dp[i - 1][1] * nums[i - 1]);

            dp[i][1] = Math.max(dp[i][1],dp[i - 1][0] * nums[i - 1]);
            dp[i][1] = Math.max(dp[i][1],dp[i - 1][1] * nums[i - 1]);
            res = Math.max(dp[i][1],res);
        }

        return res;
    }
    public int maxProduct1(int[] nums) {
        if (nums.length == 0 ){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1;i <= n;i++){
            if (dp[i - 1] != 0){
                dp[i] = Math.max(dp[i - 1] * nums[i - 1],nums[i - 1]);
            }else {
                dp[i] = nums[i - 1];
            }


        }
        int res = Integer.MIN_VALUE;
        for (int i = 1;i <= n;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }


}
