package RePractice.NewPractice_7022;

import java.util.HashSet;
import java.util.Set;

public class Code_Greedy_0731_122 {
    //dp
    public int maxProfit3(int[] prices) {
        //也可以过 dp
        int res = 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1;i < n;i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    //贪心，总是在最低处买入，在最高处卖！ 可以证明 两是比一段收入要高的！
    public int maxProfit2(int[] prices) {
        int res = 0;
        for (int i = 0;i < prices.length - 1;){

            while (i + 1 < prices.length - 1 && prices[i + 1] < prices[i]){
                i++;
            }
            int last = prices[i];
            while (i + 1 < prices.length && prices[i + 1] > prices[i]){
                i++;
            }
            res += prices[i] - last;
        }
        return res;
    }
    //差分，虽然不能同一天买卖，但是差分用在这里也合适
    public int maxProfit1(int[] prices) {
        int res = 0;
        for (int i = 1;i < prices.length;i++){
            res += Math.max(0,prices[i] - prices[i - 1]);
        }
        return res;
    }
    //dfs会超时
    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        return dfs(prices,0);
    }

    public int dfs(int[] prices,int index){
        if (index == prices.length ){
            return 0;
        }
        int max = 0;
        for (int i = index;i < prices.length;i++){
            int maxProfitV = 0;
            //吐了！ 这里不是j= index + 1 是j = i + 1
            for (int j = index + 1;j < prices.length;j++){
                if (prices[j] > prices[i]){
                    int temp = dfs(prices,j + 1) + prices[j] - prices[i];
                    maxProfitV = Math.max(temp,maxProfitV);
                }
            }
            max = Math.max(max,maxProfitV);
        }
        return max;
    }
}
