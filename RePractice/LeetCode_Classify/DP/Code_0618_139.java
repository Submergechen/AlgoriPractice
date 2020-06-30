package RePractice.LeetCode_Classify.DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

public class Code_0618_139 {
    //这种方法有问题！！
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //长度
        for (int i = 0;i < n;i++){
            dp[i][i] = wordDict.contains(s.substring(i,i+1));
        }
        for (int len = 2;len <= n;len++){
            //枚举左端点
            for (int i = 0;i + len - 1 < n;i++){
                int j = i + len - 1;
                dp[i][j] = wordDict.contains(s.substring(i,j));
                if (!dp[i][j]){
                    for (int k = i;k < j;k++){
                        if (dp[i][k] && dp[k + 1][j]){
                            dp[i][j] = true;
                            break;
                        }

                        //dp[i][j] = dp[i][j] || (dp[i][k] && dp[k + 1][j]);
                    }
                }

            }
        }
        return dp[0][n - 1];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>();
        for (String x : wordDict){
            set.add(x);
        }
        //也是用了padding!
        for (int i = 1; i <= n;i++){
            for (int j = 0;j < i;j++){
                if (dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
