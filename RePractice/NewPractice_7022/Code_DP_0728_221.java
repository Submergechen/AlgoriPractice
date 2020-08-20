package RePractice.NewPractice_7022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code_DP_0728_221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[][] dp = new int[n + 1][ m + 1];
        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= m;j++){
                if (matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.max(dp[i - 1][j - 1],Math.max(dp[i - 1][j],dp[i][j - 1])) + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max * max;
    }

}
