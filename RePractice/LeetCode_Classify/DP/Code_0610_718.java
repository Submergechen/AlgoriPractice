package RePractice.LeetCode_Classify.DP;

public class Code_0610_718 {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int res = 0;
        int[][] f = new int[m + 1][n + 1];
        f[0][0] = 0;
        for (int i = 1;i <= m;i++){
            for (int j = 1;j < n;j++){
                f[i][j] = f[i - 1][j - 1];
                if (A[i] == B[j]){
                    f[i][j] += 1;
                }
                res = Math.max(res,f[i][j]);

            }
        }
        return f[m][n];
    }
}

class Solution {
    public int findLength(int[] A, int[] B) {

        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }

        return max;

    }
}


class Solution {
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int res = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
