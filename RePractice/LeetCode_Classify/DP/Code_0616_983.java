package RePractice.LeetCode_Classify.DP;

import java.util.TreeMap;

public class Code_0616_983 {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0;i < len;i++){
            map.put(days[i],i);
        }
        int[] dp = new int[len];

        for (int i = 0;i < len;i++){
            //1tian
            dp[i] = dp[map.get(map.lowerKey(days[i] - 1))] + costs[0];
            //7tian
            dp[i] = Math.min(dp[i],dp[map.get(map.lowerKey(days[i] - 7))] + costs[1]);
            dp[i] = Math.min(dp[i],dp[map.get(map.lowerKey(days[i] - 30))] + costs[2]);
        }
        return dp[len - 1];
    }

    //另一种思路！ dp所有366天，没有旅行的话花费就是前一天前一天！
    public int mincostTickets1(int[] days, int[] costs) {
        // 20
        int len = days[days.length - 1];
        int[] seq = new int[len + 1];
        int[] dp = new int[len + 1];
        for (int x : days){
            seq[x] = 1;
        }
        dp[0] = 0;
        for (int i = 1;i < len + 1;i++){
            if (seq[i] != 1){
                dp[i] = dp[i - 1];
            }else {
                dp[i] = Math.min(dp[i - 1] + costs[0],dp[Math.max(0, i - 7)] + costs[1]);
                dp[i] = Math.min(dp[i],dp[Math.max(0, i - 30)] + costs[2]);
            }
        }
        return dp[len];

    }
}
