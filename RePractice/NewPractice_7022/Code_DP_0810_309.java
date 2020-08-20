package RePractice.NewPractice_7022;

import java.util.Arrays;
import java.util.Comparator;

public class Code_DP_0810_309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        //目前持有 1 没有 0 冷冻期 2
        int res = 0;
        int n = prices.length;
        int[][] dp = new int[n][3];

        dp[0][1] = -prices[0];
        for (int i = 1;i < n;i++){
            //第i天不持有股票，不是冷冻期； 前一天不是冷冻期 或者是冷冻期
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][2]);
            //第i天持有股票,那么前一天可能有 ， 或者前一天 刚买
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
            //不持有，并第i天冷冻期
            dp[i][2] = dp[i - 1][1] + prices[i];

        }
        return Math.max(dp[n - 1][0] , dp[n - 1][2]);
    }



}
