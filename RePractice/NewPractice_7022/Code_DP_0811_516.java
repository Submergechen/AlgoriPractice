package RePractice.NewPractice_7022;

public class Code_DP_0811_516 {
    //不连续的一般可以用dp来处理！！
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[n][n];
        for(int len = 1;len <= n;len++){
            for(int i = 0;i <= n - len ;i++){
                int j = i + len - 1;
                if(i == j){
                    dp[i][j] = 1;
                    continue;
                }
                if(chars[i] == chars[j]){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];

    }



}
