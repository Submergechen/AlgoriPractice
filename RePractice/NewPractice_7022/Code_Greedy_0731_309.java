package RePractice.NewPractice_7022;

public class Code_Greedy_0731_309 {

    public int maxProfit(int[] prices) {
        //也可以过 dp
        int res = 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1;i < n;i++){
            //第i天不持有股票
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            if (i > 2){
                dp[i][0] = Math.max(dp[i][0],dp[i - 2][1] + prices[i - 1]);
            }
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
